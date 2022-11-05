package com.example.dog_selector.repository;

import com.example.dog_selector.src.Models.Dogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogsRepository extends JpaRepository<Dogs,Long> {
    Dogs getDogsById(Long id);
    Dogs getDogsByDogSpeecy(String dogSpeecy);
    void  deleteDogsById(Long id);
}
