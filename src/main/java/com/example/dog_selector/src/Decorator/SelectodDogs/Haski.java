package com.example.dog_selector.src.Decorator.SelectodDogs;

import com.example.dog_selector.src.Decorator.SelectedDog;

public class Haski extends SelectedDog {

    public Haski() {
        description = "Haski";
    }

    @Override
    public double cost() {
        return 1.32;
    }
}
