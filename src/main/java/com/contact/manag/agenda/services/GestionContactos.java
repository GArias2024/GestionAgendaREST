package com.contact.manag.agenda.services;

import com.contact.manag.agenda.dto.ContactoDto;
import com.contact.manag.agenda.dto.ContactoResponseDto;
import com.contact.manag.agenda.dto.GetContactosResponseDto;
import com.contact.manag.agenda.exception.ContactoExistenteException;

public interface GestionContactos {

    public GetContactosResponseDto getAllContactosPag(int page, int size, String orderBy);

    public ContactoResponseDto createContacto(ContactoDto contactoDto, String id) throws ContactoExistenteException;

    public ContactoResponseDto updateContacto(ContactoDto contactoDto, String id);

    public ContactoResponseDto deleteContacto(String id);

}