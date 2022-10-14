package com.example.dog_selector.src.Observer;

import org.springframework.stereotype.Component;


public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    void notifyObserver(String observerName);
}
