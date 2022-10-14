package com.example.dog_selector.src.Decorator.SelectodDogs;


import com.example.dog_selector.src.Decorator.SelectedDog;

public class Boxer extends SelectedDog {

    public Boxer() {
        description = "Boxer";
    }

    @Override
    public double cost() {
        return 1.26;
    }
}
