package com.example.tpcontacts.repository;

import com.example.tpcontacts.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String username, String password);

    User findByEmail(String email);

    User getUserById(Long id);
}
