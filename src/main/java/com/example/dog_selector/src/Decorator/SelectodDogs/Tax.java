package com.example.dog_selector.src.Decorator.SelectodDogs;

import com.example.dog_selector.src.Decorator.SelectedDog;

public class Tax extends SelectedDog {

    public Tax() {
        description = "Tax";
    }

    @Override
    public double cost() {
        return 1.38;
    }
}
