package com.amdocs.contactservice.service.impl;

import com.amdocs.contactservice.entity.Contacts;
import com.amdocs.contactservice.repository.ContactsRepository;
import com.amdocs.contactservice.service.ContactsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactsServiceImpl implements ContactsService {

    private final ContactsRepository repository;

    public ContactsServiceImpl(ContactsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contacts saveContacts(Contacts contacts) {
        return repository.save(contacts);
    }

    @Override
    public Contacts updateContacts(Long id, Contacts newContacts) {
        Contacts contacts = repository.getById(id);

        contacts.setName(newContacts.getName());
        contacts.setEmail(newContacts.getEmail());
        contacts.setPhoneNumber(newContacts.getPhoneNumber());
        contacts.setMessage(newContacts.getMessage());
        contacts.setUserId(newContacts.getUserId());

        return  repository.save(contacts);
    }

    //    Customer customerToUpdate = customerRepository.getOne(id);
//     customerToUpdate.setName(customerDto.getName);
//customerRepository.save(customerToUpdate);
    @Override
    public boolean deleteContacts(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Contacts> getAllContacts() {
        return repository.findAll();
    }
}
