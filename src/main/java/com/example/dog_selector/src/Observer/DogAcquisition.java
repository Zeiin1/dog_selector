package com.example.dog_selector.src.Observer;


import com.example.dog_selector.src.Service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public class DogAcquisition implements Observable {


    @Autowired
    ClientServiceImpl clientService;
    List<Observer> observers = clientService.getAllClients();




    @Override
    public void registerObserver(Observer o) {
        for (Observer observer : observers) {
            if (observer.getName().equals(o.getName()) &&
                observer.getDogBreed().equals(o.getDogBreed())) {
                System.out.println("This client is already has that dog!");
                return;
            }
        }
        observers.add(o);
        clientService.addNewClient(o);

    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        clientService.removeClient(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void notifyObserver(String observerName) {
        for (Observer observer : observers) {
            if (observer.getName().equals(observerName)) {
                observer.update();
            }
        }
    }
}
