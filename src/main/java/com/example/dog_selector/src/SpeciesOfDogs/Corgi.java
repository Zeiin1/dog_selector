package com.example.dog_selector.src.SpeciesOfDogs;


import com.example.dog_selector.src.Behaviors_and_Realizations.Intellect_realizations.Trained;
import com.example.dog_selector.src.Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import com.example.dog_selector.src.Behaviors_and_Realizations.mood_realizations.Calm;
import com.example.dog_selector.src.Behaviors_and_Realizations.size_realizations.Medium;

public class Corgi extends Dog implements DescriptionOfDog {
    private final String dogSpeecy = "Corgi";
    public Corgi()
    {
        this.intellect = "TRAINED";
        this.size = "MEDIUM";
        this.mood = "CALM";
        this.lifeStyle = "DOMESTIC";
    }

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Medium().size() + "\n" +
                "3. " + new Calm().mood() + "\n" +
                "4. " + new Domestic().lifestyle());
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }

    @Override
    public String getDescription() {
        return "Adaptable and loving with the whole family," +
                " Corgis can fit into just about any household," +
                " whether it’s an apartment or large home with a yard." +
                " However, they do have quite a bit of energy for a small dog." +
                " They’ll need plenty of walks and active play sessions. ";
    }
}
