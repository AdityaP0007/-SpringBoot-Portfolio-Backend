package com.app.rohan.services.impl;

import com.app.rohan.pojos.Contact;
import com.app.rohan.repositories.ContactRepository;
import com.app.rohan.services.IContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements IContact {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContactDetails() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactByEmailId(String email) {
        Contact contact = contactRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("The contact with email id: "+ email + " not found"));
        return contact;
    }

    @Override
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }
}
