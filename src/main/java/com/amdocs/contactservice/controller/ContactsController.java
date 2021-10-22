package com.amdocs.contactservice.controller;

import com.amdocs.contactservice.entity.Contacts;
import com.amdocs.contactservice.service.impl.ContactsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContactsController {

    private final ContactsServiceImpl contactsService;

    public ContactsController(ContactsServiceImpl contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping("/contacts")
    public ResponseEntity getAllContacts() {
        return new ResponseEntity(contactsService.getAllContacts(), HttpStatus.OK);
    }

//    @GetMapping("/contacts")
//    public ResponseEntity getContactsByUserId(@PathVariable Long id) {
//        return new ResponseEntity(contactsService.getContactsByUserId(id), HttpStatus.OK);
//    }

    @PostMapping("/contacts")
    public ResponseEntity saveContacts(@RequestBody Contacts contacts) {
        try {
            return new ResponseEntity(contactsService.saveContacts(contacts), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity("Checkout the data inputed, please. Seems like we have a error, Houston.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity updateContacts(@RequestBody Contacts contacts, @PathVariable Long id) {
        try {
            return new ResponseEntity(contactsService.updateContacts(id, contacts), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Looks like this id not exists, check it out please.", HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity deleteContacts(@PathVariable Long id) {
        try {
            return new ResponseEntity(contactsService.deleteContacts(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Looks like this id not exists, check it out please.", HttpStatus.NOT_IMPLEMENTED);
        }
    }


}
