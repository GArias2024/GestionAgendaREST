package com.contact.manag.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.manag.agenda.model.Usuario;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface UruarioRepository extends JpaRepository<Usuario, Long> {

    Set<Usuario> findByIdIn(Collection<Long> ids);

    Optional<Usuario> findByUsername(String username);
}
