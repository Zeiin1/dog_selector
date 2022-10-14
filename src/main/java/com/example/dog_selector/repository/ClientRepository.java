package com.example.dog_selector.repository;

import com.example.dog_selector.src.Models.BackClient;
import com.example.dog_selector.src.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<BackClient,Long> {
  BackClient findByDogBayer(String dogBayer);
  void deleteBackClientByDogBayer(String dogBayer);
}
