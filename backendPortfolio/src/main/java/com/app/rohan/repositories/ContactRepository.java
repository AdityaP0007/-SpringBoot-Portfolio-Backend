package com.app.rohan.repositories;

import com.app.rohan.pojos.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Optional<Contact> findByEmail(String email);
}
