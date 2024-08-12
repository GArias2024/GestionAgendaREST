package com.contact.manag.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.manag.agenda.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

    boolean existsById(int id);
}
