package com.example.dog_selector.src.SpeciesOfDogs;

public class MostPopularDog {
     Akita_Inu akita_inu = new Akita_Inu();
     private String speecyOfMostPopularDog = akita_inu.getDogSpeecy();
    private static MostPopularDog mostPopularDogInstance;
     public static synchronized MostPopularDog getInstanceOfMostPopularDog()
     {

         if(mostPopularDogInstance == null)
         {
             mostPopularDogInstance = new MostPopularDog();
             System.out.println();
             System.out.println("the instance of most popular dog has been create using new operator");
             System.out.println();
             return mostPopularDogInstance;

         }
         else {
             System.out.println();
             System.out.println("the instance of most popular dog cannot be create more than 1 times");
             System.out.println();
             return mostPopularDogInstance;
         }

     }
     private MostPopularDog(){}

    public String getSpeecyOfMostPopularDog() {
        return speecyOfMostPopularDog;
    }
}
