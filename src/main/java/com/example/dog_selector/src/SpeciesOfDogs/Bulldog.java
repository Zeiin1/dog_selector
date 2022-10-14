package com.example.dog_selector.src.SpeciesOfDogs;


import com.example.dog_selector.src.Behaviors_and_Realizations.Intellect_realizations.Trained;
import com.example.dog_selector.src.Behaviors_and_Realizations.lifestyle_realizations.Street;
import com.example.dog_selector.src.Behaviors_and_Realizations.mood_realizations.Aggressive;
import com.example.dog_selector.src.Behaviors_and_Realizations.size_realizations.Medium;

public class Bulldog extends Dog implements DescriptionOfDog {
    private final String dogSpeecy = "Bulldog";
    public Bulldog()
    {
        this.intellect ="TRAINED";
        this.size ="MEDIUM";
        this.mood = "AGGRESSIVE";
        this.lifeStyle = "AGGRESSIVE";
    }

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new Trained().intellect() + "\n" +
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
        return " the modern Bulldog is considered to be a peace-loving breed. " +
                "It should be noted that this claim is a traditional and widely" +
                " accepted generalization about the breed, and the behaviour of individual Bulldogs may differ.";
    }
}
