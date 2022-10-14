package com.example.dog_selector.src.Decorator.SelectodDogs;


import com.example.dog_selector.src.Decorator.SelectedDog;

public class Dalmatian extends SelectedDog {

    public Dalmatian() {
        description = "Dalmatian";
    }

    @Override
    public double cost() {
        return 1.30;
    }
}
