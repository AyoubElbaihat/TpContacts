package com.example.tpcontacts.controller.api;

import com.example.tpcontacts.controller.dto.ContactDto;
import com.example.tpcontacts.repository.entity.Contact;
import com.example.tpcontacts.repository.entity.User;
import com.example.tpcontacts.service.ContactService;
import com.example.tpcontacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contacts")
public class ApiContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<List<ContactDto>> fetchAllContacts(@PathVariable("id") Long id) {
        User currentUser = userService.getUserById(id);
        List<ContactDto> contactDtos = contactService
                .getAllContactsByUser(currentUser)
                .stream()
                .map(contact -> {
                    ContactDto dto = new ContactDto();
                    dto.setId(contact.getId());
                    dto.setFirstname(contact.getFirstname());
                    dto.setLastname(contact.getLastname());
                    dto.setAddress(contact.getAddress());
                    dto.setPhone(contact.getPhone());
                    dto.setPhoto(contact.getPhoto());
                    dto.setEmail(contact.getEmail());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(contactDtos);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ContactDto> addContact(@PathVariable("id") Long id, @RequestBody Contact contact) {
        User currentUser = userService.getUserById(id);
        contact.setUser(currentUser);
        Contact createdContact = contactService.saveContact(contact);
        ContactDto contactDto = new ContactDto(createdContact.getId(),
                createdContact.getFirstname(), createdContact.getLastname(),
                createdContact.getEmail(), createdContact.getPhone(),
                createdContact.getPhoto(), createdContact.getAddress());
        return ResponseEntity.ok(contactDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContactById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/{idContact}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable("id") Long id,@PathVariable("idContact") Long idContact, @RequestBody Contact contact) {
        User currentUser = userService.getUserById(id);
        contact.setUser(currentUser);
        contact.setId(idContact);
        Contact updetededContact = contactService.saveContact(contact);
        ContactDto contactDto = new ContactDto(updetededContact.getId(),
                updetededContact.getFirstname(), updetededContact.getLastname(),
                updetededContact.getEmail(), updetededContact.getPhone(),
                updetededContact.getPhoto(), updetededContact.getAddress());
        return ResponseEntity.ok(contactDto);
    }
}