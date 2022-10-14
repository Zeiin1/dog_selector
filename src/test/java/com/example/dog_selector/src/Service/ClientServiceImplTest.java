package com.example.dog_selector.src.Service;

import com.example.dog_selector.repository.ClientRepository;
import com.example.dog_selector.src.Models.BackClient;
import com.example.dog_selector.src.Models.Client;
import com.example.dog_selector.src.Observer.Observer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ClientServiceImplTest {
    @Autowired
    private ClientRepository clientRepository;


    @Test
    public void checkMethod()
    {

        clientRepository.deleteAll();


    }


}