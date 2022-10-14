package com.example.dog_selector.src.SpeciesOfDogs;


import com.example.dog_selector.src.Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import com.example.dog_selector.src.Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import com.example.dog_selector.src.Behaviors_and_Realizations.mood_realizations.Calm;
import com.example.dog_selector.src.Behaviors_and_Realizations.size_realizations.Big;

public class Samoed extends Dog implements DescriptionOfDog {
    private final String dogSpeecy = "Samoed";
    public Samoed()
    {
        this.intellect = "NOTRAINED";
        this.size = "BIG";
        this.mood ="CALM";
        this.lifeStyle = "DOMESTIC";
    }

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new NoTrained().intellect() + "\n" +
                "2. " + new Big().size() + "\n" +
                "3. " + new Calm().mood() + "\n" +
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
