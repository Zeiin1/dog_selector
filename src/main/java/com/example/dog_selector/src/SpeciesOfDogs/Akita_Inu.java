package com.example.dog_selector.src.SpeciesOfDogs;


import com.example.dog_selector.src.Behaviors_and_Realizations.Intellect_realizations.Trained;
import com.example.dog_selector.src.Behaviors_and_Realizations.lifestyle_realizations.Street;
import com.example.dog_selector.src.Behaviors_and_Realizations.mood_realizations.Calm;
import com.example.dog_selector.src.Behaviors_and_Realizations.size_realizations.Big;

public class Akita_Inu extends Dog implements DescriptionOfDog {
    private final String dogSpeecy = "Akita Inu";
    public Akita_Inu()
    {
        this.intellect = "TRAINED";
        this.size = "BIG";
        this.mood = "CALM";
        this.lifeStyle ="STREET";

    }

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Big().size() + "\n" +
                "3. " + new Calm().mood() + "\n" +
                "4. " + new Street().lifestyle());
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }

    @Override
    public String getDescription() {
        return "They depend on us for, at minimum, food and shelter, and deserve much more. " +
                "When you take a dog into your life, you need to understand the commitment that dog ownership entails.";
    }
}
