package com.example.dog_selector.src.Decorator.SelectodDogs;


import com.example.dog_selector.src.Decorator.SelectedDog;

public class Corgi extends SelectedDog {

    public Corgi() {
        description = "Corgi";
    }

    @Override
    public double cost() {
        return 1.29;
    }
}
