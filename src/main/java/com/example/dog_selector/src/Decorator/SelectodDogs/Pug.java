package com.example.dog_selector.src.Decorator.SelectodDogs;

import com.example.dog_selector.src.Decorator.SelectedDog;

public class Pug extends SelectedDog {

    public Pug() {
        description = "Pug";
    }

    @Override
    public double cost() {
        return 1.35;
    }
}
