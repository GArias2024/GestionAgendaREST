package com.contact.manag.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.contact.manag.agenda.constants.Constants;
import com.contact.manag.agenda.dto.ContactoDto;
import com.contact.manag.agenda.dto.ContactoResponseDto;
import com.contact.manag.agenda.dto.GetContactosResponseDto;
import com.contact.manag.agenda.exception.BadFieldRequestException;
import com.contact.manag.agenda.exception.ManyResultsException;
import com.contact.manag.agenda.services.GestionContactos;

import io.github.bucket4j.Bucket;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/contactos")
@SecurityRequirement(name = "BasicAuth")
@Validated
public class ContactoController {

    @Autowired
    private GestionContactos gestionContactos;

    @Autowired
    private Bucket rateLimiter;

    @GetMapping
    public ResponseEntity<GetContactosResponseDto> getContactos(
            @Schema(hidden = true) @RequestParam(required = false) String orderBy,
            @RequestParam(defaultValue = "0") String page,
            @RequestParam(defaultValue = "5") String size) {

        if (!rateLimiter.tryConsume(1)) {
            throw new ManyResultsException(Constants.ERROR_MANY_REQUEST);
        }

        if (null != orderBy && !Constants.OrderBy.isValid(orderBy)) {
            throw new IllegalArgumentException();
        }

        GetContactosResponseDto contactosResp = gestionContactos.getAllContactosPag(Integer.parseInt(page),
                Integer.parseInt(size), orderBy);

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(contactosResp);
    }

    @PostMapping
    public ResponseEntity<ContactoResponseDto> createContacto(
            @Schema(hidden = true) @RequestHeader("id") String id,
            @Valid @RequestBody ContactoDto contactoDto) {

        if (!rateLimiter.tryConsume(1)) {
            throw new ManyResultsException(Constants.ERROR_MANY_REQUEST);
        }

        validarId(id);
        ContactoResponseDto createdContacto = gestionContactos.createContacto(contactoDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContacto);
    }

    @PutMapping
    public ResponseEntity<ContactoResponseDto> updateContacto(
            @Schema(hidden = true) @RequestHeader("id") String id,
            @Valid @RequestBody ContactoDto contactoDto) {

        if (!rateLimiter.tryConsume(1)) {
            throw new ManyResultsException(Constants.ERROR_MANY_REQUEST);
        }

        validarId(id);
        ContactoResponseDto updateContacResp = gestionContactos.updateContacto(contactoDto, id);

        return ResponseEntity.status(HttpStatus.CREATED).body(updateContacResp);
    }

    @DeleteMapping
    public ResponseEntity<ContactoResponseDto> deleteContacto(
            @Schema(hidden = true) @RequestHeader("id") String id) {

        if (!rateLimiter.tryConsume(1)) {
            throw new ManyResultsException(Constants.ERROR_MANY_REQUEST);
        }

        validarId(id);
        ContactoResponseDto deleteContactoResp = gestionContactos.deleteContacto(id);

        return ResponseEntity.status(HttpStatus.OK).body(deleteContactoResp);
    }

    public void validarId(String id) {
        if (id == null || id.isBlank()) {
            throw new BadFieldRequestException(Constants.VALID_ID_EMPTY_MSG);
        }
        if (id.length() > 9) {
            throw new BadFieldRequestException(Constants.VALID_ID_MAX_CHAR_MSG);
        }
        if (!id.matches("\\d+")) {
            throw new BadFieldRequestException(Constants.VALID_ID_ONLY_NUM_MSG);
        }
    }

}
