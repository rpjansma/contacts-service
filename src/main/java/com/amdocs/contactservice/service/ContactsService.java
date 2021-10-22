package com.amdocs.contactservice.service;

import com.amdocs.contactservice.entity.Contacts;

import java.util.List;

public interface ContactsService {

    Contacts saveContacts(Contacts user);

    Contacts updateContacts(Long id, Contacts user);

    boolean deleteContacts(Long id);

    List<Contacts> getAllContacts();
}
