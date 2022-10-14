package com.example.dog_selector.src.SpeciesOfDogs;


import com.example.dog_selector.src.Behaviors_and_Realizations.Intellect_realizations.Trained;
import com.example.dog_selector.src.Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import com.example.dog_selector.src.Behaviors_and_Realizations.mood_realizations.Active;
import com.example.dog_selector.src.Behaviors_and_Realizations.size_realizations.Big;

public class Haski extends Dog implements DescriptionOfDog {
    private final String dogSpeecy = "Haski";
    public Haski()
    {
        this.intellect = "TRAINED";
        this.size = "BIG";
        this.mood = "ACTIVE";
        this.lifeStyle ="DOMESTIC";
    }

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Big().size() + "\n" +
                "3. " + new Active().mood() + "\n" +
                "4. " + new Domestic().lifestyle());
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
