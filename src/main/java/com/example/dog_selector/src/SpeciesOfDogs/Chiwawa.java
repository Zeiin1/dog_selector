package com.example.dog_selector.src.SpeciesOfDogs;


import com.example.dog_selector.src.Behaviors_and_Realizations.Intellect_realizations.Trained;
import com.example.dog_selector.src.Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import com.example.dog_selector.src.Behaviors_and_Realizations.mood_realizations.Aggressive;
import com.example.dog_selector.src.Behaviors_and_Realizations.size_realizations.Small;

public class Chiwawa extends Dog implements DescriptionOfDog {
    private final String dogSpeecy = "Chiwawa";
    public Chiwawa()
    {
        this.intellect = "TRAINED";
        this.size ="SMALL";
        this.mood ="AGGRESSIVE";
        this.lifeStyle = "DOMESTIC";
    }

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Small().size() + "\n" +
                "3. " + new Aggressive().mood() + "\n" +
                "4. " + new Domestic().lifestyle());
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }

    @Override
    public String getDescription() {
        return "Chihuahuas love nothing more than being with their people" +
                " — even novice pet parents — and require a minimum of grooming and exercise. " +
                "They make excellent apartment dogs who’ll get along with the whole family.";
    }
}
