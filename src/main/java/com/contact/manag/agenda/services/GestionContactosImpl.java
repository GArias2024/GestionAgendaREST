package com.contact.manag.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.contact.manag.agenda.constants.Constants;
import com.contact.manag.agenda.dto.ContactoDto;
import com.contact.manag.agenda.dto.ContactoResponseDto;
import com.contact.manag.agenda.dto.GetContactosResponseDto;
import com.contact.manag.agenda.exception.ContactoExistenteException;
import com.contact.manag.agenda.exception.NotFoundException;
import com.contact.manag.agenda.model.Contacto;
import com.contact.manag.agenda.repository.ContactoRepository;

@Service
public class GestionContactosImpl implements GestionContactos {

    @Autowired
    private ContactoRepository contactoRep;

    public GetContactosResponseDto getAllContactosPag(int page, int size, String orderBy) {
        Pageable pageable;
        if (null == orderBy) {
            pageable = PageRequest.of(page, size);
        } else {
            pageable = PageRequest.of(page, size, Sort.by(orderBy));
        }

        Page<Contacto> contactsResult = contactoRep.findAll(pageable);

        List<ContactoResponseDto> dtoList = contactsResult.getContent().stream()
                .map(this::EntityToContactoResponseDto)
                .collect(Collectors.toList());

        GetContactosResponseDto response = new GetContactosResponseDto();
        response.setListContactos(dtoList);
        response.setTotal(contactsResult.getTotalElements());
        response.setPag(contactsResult.getTotalPages());
        response.setElemPag(contactsResult.getSize());
        response.setPagActu(contactsResult.getNumber());

        return response;
    }

    public ContactoResponseDto createContacto(ContactoDto contactoDto, String id) throws ContactoExistenteException {
        Contacto contacto = contactoDtoToEntity(contactoDto, id);
        if (contactoRep.existsById(contacto.getCod_id())) {
            throw new ContactoExistenteException(Constants.ERROR_ALREADY_EXIST);
        }
        return EntityToContactoResponseDto(contactoRep.save(contacto));
    }

    public ContactoResponseDto updateContacto(ContactoDto contactoDto, String id) {
        Contacto contacto = contactoRep.findById(Integer.parseInt(id)).orElseThrow(
                () -> new NotFoundException(Constants.ERROR_NOT_FOUND + " id = " + id));

        contacto.setVal_nombre(contactoDto.getNombre());
        contacto.setVal_apellidos(contactoDto.getApellidos());
        contacto.setVal_email(contactoDto.getEmail());
        Contacto updatedContacto = contactoRep.save(contacto);
        return EntityToContactoResponseDto(updatedContacto);
    }

    public ContactoResponseDto deleteContacto(String id) {
        int idInt = Integer.parseInt(id);

        Contacto contacto = contactoRep.findById(idInt).orElseThrow(
                () -> new NotFoundException(Constants.ERROR_NOT_FOUND + " id = " + id));

        contactoRep.deleteById(idInt);
        return EntityToContactoResponseDto(contacto);
    }

    public Contacto contactoDtoToEntity(ContactoDto contacDto, String id) {
        Contacto contacto = new Contacto();
        contacto.setCod_id(Integer.parseInt(id));
        contacto.setVal_nombre(contacDto.getNombre());
        contacto.setVal_email(contacDto.getEmail());
        contacto.setVal_apellidos(contacDto.getApellidos());
        return contacto;
    }

    public ContactoResponseDto EntityToContactoResponseDto(Contacto contacDto) {
        ContactoResponseDto contacto = new ContactoResponseDto();
        contacto.setId(contacDto.getCod_id());
        contacto.setNombre(contacDto.getVal_nombre());
        contacto.setEmail(contacDto.getVal_email());
        contacto.setApellidos(contacDto.getVal_apellidos());
        return contacto;
    }

}
