package com.example.tpcontacts.service;

import com.example.tpcontacts.repository.ContactRepository;
import com.example.tpcontacts.repository.entity.Contact;
import com.example.tpcontacts.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }

    public List<Contact> getAllContactsByUser(User currentUser) {
        return contactRepository.getAllContactsByUser(currentUser);
    }

    public List<Contact> searchContactsByUserAndKeyword(User user, String keyword) {
        return contactRepository.findByUserAndFirstnameContainingOrUserAndLastnameContainingOrUserAndEmailContainingOrUserAndPhoneContaining(user, keyword, user, keyword, user, keyword, user, keyword);
    }

    public Contact findContactById(Long id) {
        return contactRepository.findContactById(id);
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact fetchContactById(Long id) {
        return contactRepository.findContactById(id);
    }
}

