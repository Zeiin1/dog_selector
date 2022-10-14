package com.example.dog_selector.repository;

import com.example.dog_selector.src.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByFirstname(String firstName);
    User findUserByRole(String role);
    User findUserByLogin(String login);
    User findUserById(Long id);
    User deleteUserByFirstname(String firstName);
}
