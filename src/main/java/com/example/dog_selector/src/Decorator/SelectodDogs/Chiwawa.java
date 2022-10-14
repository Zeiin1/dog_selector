package com.example.dog_selector.src.Decorator.SelectodDogs;


import com.example.dog_selector.src.Decorator.SelectedDog;

public class Chiwawa extends SelectedDog {

    public Chiwawa() {
        description = "Chiwawa";
    }

    @Override
    public double cost() {
        return 1.28;
    }
}
