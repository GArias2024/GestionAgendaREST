package com.contact.manag.agenda.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.contact.manag.agenda.model.Usuario;
import com.contact.manag.agenda.repository.UruarioRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UruarioRepository personRepository;

    public UserDetailServiceImpl(UruarioRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> personOptional = personRepository.findByUsername(username);
        if (personOptional.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no existe".formatted(username));
        }
        Usuario person = personOptional.get();

        return new User(person.getUsername(), person.getPasswordHash(),
                getAuthorities(person));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Usuario person) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" +
                person.getRole().name()));
    }
}
