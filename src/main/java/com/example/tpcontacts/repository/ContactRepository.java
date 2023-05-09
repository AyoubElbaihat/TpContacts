package com.example.tpcontacts.repository;

import com.example.tpcontacts.repository.entity.Contact;
import com.example.tpcontacts.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> getAllContactsByUser(User currentUser);

    List<Contact> findByUserAndFirstnameContainingOrUserAndLastnameContainingOrUserAndEmailContainingOrUserAndPhoneContaining(User user, String keyword, User user1, String keyword1, User user2, String keyword2, User user3, String keyword3);

    Contact findContactById(Long id);
}
