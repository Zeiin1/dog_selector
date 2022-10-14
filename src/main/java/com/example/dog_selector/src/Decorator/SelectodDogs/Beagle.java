package com.example.dog_selector.src.Decorator.SelectodDogs;


import com.example.dog_selector.src.Decorator.SelectedDog;

public class Beagle extends SelectedDog {

    public Beagle() {
        description = "Beagle";
    }

    @Override
    public double cost() {
        return 1.25;
    }
}
