package com.example.dog_selector.src.Decorator.SelectodDogs;

import com.example.dog_selector.src.Decorator.SelectedDog;

public class Puddle extends SelectedDog {

    public Puddle() {
        description = "Puddle";
    }

    @Override
    public double cost() {
        return 1.34;
    }
}
