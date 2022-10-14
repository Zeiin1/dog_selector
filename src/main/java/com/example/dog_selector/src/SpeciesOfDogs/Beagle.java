package com.example.dog_selector.src.SpeciesOfDogs;

import com.example.dog_selector.src.Behaviors_and_Realizations.Intellect_realizations.Trained;
import com.example.dog_selector.src.Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import com.example.dog_selector.src.Behaviors_and_Realizations.lifestyle_realizations.Street;
import com.example.dog_selector.src.Behaviors_and_Realizations.mood_realizations.Active;
import com.example.dog_selector.src.Behaviors_and_Realizations.mood_realizations.Calm;
import com.example.dog_selector.src.Behaviors_and_Realizations.size_realizations.Big;
import com.example.dog_selector.src.Behaviors_and_Realizations.size_realizations.Medium;

public class Beagle extends Dog implements DescriptionOfDog {
    private final String dogSpeecy = "Beagle";
    public Beagle()
    {
        this.intellect = "TRAINED";
        this.size = "MEDIUM";
        this.mood = "ACTIVE";
        this.lifeStyle ="DOMESTIC";
    }

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Medium().size() + "\n" +
                "3. " + new Active().mood() + "\n" +
                "4. " + new Domestic().lifestyle());
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }

    @Override
    public String getDescription() {
        return "Small, compact, and hardy, Beagles are active companions for kids and adults alike" +
                ". Canines of this dog breed are merry and fun loving, but being hounds," +
                " they can also be stubborn and require patient, creative training techniques";
    }
}
