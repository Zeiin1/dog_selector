package com.example.dog_selector.src.SpeciesOfDogs;


import com.example.dog_selector.src.Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import com.example.dog_selector.src.Behaviors_and_Realizations.lifestyle_realizations.Street;
import com.example.dog_selector.src.Behaviors_and_Realizations.mood_realizations.Aggressive;
import com.example.dog_selector.src.Behaviors_and_Realizations.size_realizations.Medium;

public class Boxer extends Dog  implements DescriptionOfDog {
    private final String dogSpeecy = "Boxer";
    public Boxer()
    {
        this.intellect ="NOTRAINED";
        this.size = "MEDIUM";
        this.mood = "AGGRESSIVE";
        this.lifeStyle ="STREET";
    }

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new NoTrained().intellect() + "\n" +
                "2. " + new Medium().size() + "\n" +
                "3. " + new Aggressive().mood() + "\n" +
                "4. " + new Street().lifestyle());
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }

    @Override
    public String getDescription() {
        return "Boxers are intelligent, high-energy, playful dogs that like to stay busy." +
                " Their temperament reflects their breeding. They prefer to be in the " +
                "company of their owners and are loyal pets that will fiercely guard their family and home against strangers.";
    }
}
