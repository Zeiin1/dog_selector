package com.example.dog_selector.src.Service;

import com.example.dog_selector.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testMethodOfRepository()
    {
       userRepository.deleteAll();
    }

}