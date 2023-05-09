package com.example.tpcontacts.controller;


import com.example.tpcontacts.repository.entity.Contact;
import com.example.tpcontacts.repository.entity.User;
import com.example.tpcontacts.service.ContactService;
import com.example.tpcontacts.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String fetchAllContacts(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        User currentUser = userService.getUserByEmail(email);
        List<Contact> contacts = contactService.getAllContactsByUser(currentUser);
        model.addAttribute("contacts", contacts);
        return "list-contacts";
    }

    @GetMapping("/search")
    public String searchContacts(@RequestParam String keyword, HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        User currentUser = userService.getUserByEmail(email);
        List<Contact> contacts = contactService.searchContactsByUserAndKeyword(currentUser, keyword);
        model.addAttribute("contacts", contacts);
        return "list-contacts";
    }


    @GetMapping("/add")
    public String addContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "add-contact";
    }

    @PostMapping("/add")
    public String addContactSubmit(@ModelAttribute Contact contact, HttpSession session) {
        String email = (String) session.getAttribute("email");
        User currentUser = userService.getUserByEmail(email);
        contact.setUser(currentUser);
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }
    @GetMapping("/edit/{id}")
    public String editContactForm(@PathVariable("id") Long id, Model model) {
        System.out.println(id);
        Contact contact = contactService.findContactById(id);
        model.addAttribute("contact", contact);
        return "edit-contact";
    }

    @PostMapping("/edit/{id}")
    public String editContactSubmit(@PathVariable("id") Long id, @ModelAttribute("contact") Contact contact, HttpSession session) {
        contact.setId(id);
        String email = (String) session.getAttribute("email");
        User currentUser = userService.getUserByEmail(email);
        contact.setUser(currentUser);
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContactById(id);
        return "redirect:/contacts";
    }
}

