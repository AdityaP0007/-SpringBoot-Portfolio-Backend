package com.app.rohan.services;

import com.app.rohan.pojos.Contact;

import java.util.List;

public interface IContact {
    public List<Contact> getAllContactDetails();

    public Contact getContactByEmailId(String email);

    public void addContact(Contact contact);
}
