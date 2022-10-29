package com.example.dog_selector.src.Service;

import com.example.dog_selector.repository.DogsRepository;
import com.example.dog_selector.src.Models.Dogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogsServiceImpl {
    @Autowired
    private DogsRepository dogsRepository;

    public void saveDog(Dogs dogs)
    {
        dogsRepository.save(dogs);
    }

    public Dogs getDogById(Long id) {
        return dogsRepository.getDogsById(id);
    }

    public String findDogSpeecy(String size, String mood, String intellect, String lifeStyle) {
        List<Dogs> dogsList = dogsRepository.findAll();
        for(Dogs dogs: dogsList)
        {
            if(dogs.getIntellect().equals(intellect) && dogs.getSize().equals(size)
            && dogs.getMood().equals(mood) && dogs.getLifeStyle().equals(lifeStyle))
            {
                return dogs.getDogSpeecy();
            }
        }
        return null;
    }

    public Dogs getDogBySpeecy(String speecyOfDog) {
        return dogsRepository.getDogsByDogSpeecy(speecyOfDog);
    }
}
