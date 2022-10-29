package com.example.dog_selector.src.Service;



import com.example.dog_selector.repository.ClientRepository;
import com.example.dog_selector.src.Models.BackClient;
import com.example.dog_selector.src.Models.Client;
import com.example.dog_selector.src.Observer.Observer;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class ClientServiceImpl {
    @Autowired
    private ClientRepository clientRepository;





    public List<Observer> getAllClients(){
        List<Observer> observers = new ArrayList<>();
     List<BackClient> backClients = clientRepository.findAll();
       for(BackClient client : backClients)
       {
           Observer observer = new Client(client.getDogBayer(),client.getDogSpeecyForDB(),
                   client.getDogSpeecy(),client.getDate());
           observers.add(observer);

       }
        return observers;
    }
    public void addNewClient(Observer observer)
    {
        BackClient client = new BackClient(observer.getName(),observer.getDogSpeecyForDB(),
                observer.getDogBreed(),observer.getDate());
        clientRepository.save(client);
    }

    public void removeClient(Observer observer)
    {
        Client client = (Client) observer;
        clientRepository.deleteBackClientByDogBayer(client.getDogBayer());
    }

    public BackClient findClientByName(String firstname) {
        return clientRepository.findByDogBayer(firstname);

    }
    public void setServicesAndItsCost(Client client, String description, double cost)
    {
        BackClient client1 = clientRepository.findByDogBayer(client.getDogBayer());
        client1.setCost(cost);
        client1.setDescription(description);
        clientRepository.save(client1);
    }

   /* public static boolean hasThatDog(String dog_buyer, String dog_speecy)
    {

        Client client1 = clientRepository.findClientByDogBayer(dog_buyer);
        if(client1 == null || !client1.getDogSpeecy().equals(dog_speecy))
        {
            return false;
        }return true;
    }*/




}
