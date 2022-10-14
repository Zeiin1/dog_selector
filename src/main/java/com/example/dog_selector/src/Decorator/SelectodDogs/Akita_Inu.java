package com.example.dog_selector.src.Decorator.SelectodDogs;


import com.example.dog_selector.src.Decorator.SelectedDog;

public class Akita_Inu extends SelectedDog {

    public Akita_Inu() {
        description = "Akita Inu";
    }

    @Override
    public double cost() {
        return 1.24;
    }
}
