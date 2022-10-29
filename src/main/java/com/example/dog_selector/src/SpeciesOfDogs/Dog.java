package com.example.dog_selector.src.SpeciesOfDogs;


import com.example.dog_selector.src.Behaviors_and_Realizations.IntellectBehavior;
import com.example.dog_selector.src.Behaviors_and_Realizations.LifestyleBehavior;
import com.example.dog_selector.src.Behaviors_and_Realizations.MoodBehavior;
import com.example.dog_selector.src.Behaviors_and_Realizations.SizeBehavior;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@ToString
@Getter
@Setter
public abstract class Dog implements DescriptionOfDog {
    private final String BIG = "BIG";
    private final String MEDIUM = "MEDIUM";
    private final String SMALL = "SMALL";
    private final String CALM = "CALM";
    private final String AGGRESSIVE = "AGGRESSIVE";
    private final String ACTIVE = "ACTIVE";
    private final String TRAINED = "TRAINED";
    private final String NOTRAINED = "NOTRAINED";
    private final String DOMESTIC = "DOMESTIC";
    private final String STREET = "STREET";

    public abstract void display();
    public abstract String getDogSpeecy();

    private IntellectBehavior intellectBehavior;
    private SizeBehavior sizeBehavior;
    private MoodBehavior moodBehavior;
    private LifestyleBehavior lifestyleBehavior;
    private Dog dogIs;
    public String size;
    public String intellect;
    public String mood;
    public String lifeStyle;
    public static Dog dogInstance;

    public DescriptionOfDog getDescriptionOfDog(String breed)
    {
        List<Dog> dogList = (List<Dog>) Arrays.asList(
                new Akita_Inu(), new Beagle(), new Boxer(), new Bulldog(),
                new Chiwawa(), new Corgi(), new Dalmatian(), new Doberman(),
                new Haski(), new Labrador(), new Puddle(), new Pug(),
                new Samoed(), new Spitz(), new Tax());
        for(Dog forCheck: dogList){
            if(forCheck.getDogSpeecy().equals(breed));
            {
                return  forCheck;
            }

            }

        return null;
    }

    public String defineTypeOfDog(Dog dog) {
        List<Dog> dogList = (List<Dog>) Arrays.asList(
                new Akita_Inu(), new Beagle(), new Boxer(), new Bulldog(),
                new Chiwawa(), new Corgi(), new Dalmatian(), new Doberman(),
                new Haski(), new Labrador(), new Puddle(), new Pug(),
                new Samoed(), new Spitz(), new Tax());

        for(Dog forCheck: dogList){
            if(forCheck.getLifeStyle().equals(dog.getLifeStyle())&&
            forCheck.getIntellect().equals(dog.getIntellect())&&
            forCheck.getMood().equals(dog.getMood())&&
            forCheck.getSize().equals(dog.getSize()))
            {
                return forCheck.getDogSpeecy();

            }
        }
        return "Corgi";

    }

    public void setIntellectBehavior(IntellectBehavior intellectBehavior) {
        this.intellectBehavior = intellectBehavior;
    }
    public String getIntellectBehavior() {
        return this.intellectBehavior.intellect();
    }

    public void setSizeBehavior(SizeBehavior sizeBehavior) {
        this.sizeBehavior = sizeBehavior;
    }
    public String getSizeBehavior() {
        return this.sizeBehavior.size();
    }

    public void setMoodBehavior(MoodBehavior moodBehavior) {
        this.moodBehavior = moodBehavior;
    }
    public String getMoodBehavior() {
        return this.moodBehavior.mood();
    }

    public void setLifestyleBehavior(LifestyleBehavior lifestyleBehavior) {
        this.lifestyleBehavior = lifestyleBehavior;
    }
    public String getLifestyleBehavior() {
        return this.lifestyleBehavior.lifestyle();
    }

    public Dog getDogIs() {

        return this.dogIs; }
}
