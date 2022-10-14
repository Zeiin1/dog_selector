package com.example.dog_selector.controller;

import com.example.dog_selector.src.Behaviors_and_Realizations.Intellect_realizations.*;
import com.example.dog_selector.src.Behaviors_and_Realizations.lifestyle_realizations.*;
import com.example.dog_selector.src.Behaviors_and_Realizations.mood_realizations.*;

import com.example.dog_selector.src.Behaviors_and_Realizations.size_realizations.*;
import com.example.dog_selector.src.Decorator.DepRecFunc;
import com.example.dog_selector.src.Decorator.Grafted;
import com.example.dog_selector.src.Decorator.SelectedDog;
import com.example.dog_selector.src.Decorator.SelectodDogs.*;
import com.example.dog_selector.src.Models.BackClient;
import com.example.dog_selector.src.Models.Client;
import com.example.dog_selector.src.Models.User;
import com.example.dog_selector.src.Observer.DogAcquisition;
import com.example.dog_selector.src.Observer.Observer;
import com.example.dog_selector.src.Service.ClientServiceImpl;
import com.example.dog_selector.src.Service.UserServiceImpl;
import com.example.dog_selector.src.SpeciesOfDogs.DescriptionOfDog;
import com.example.dog_selector.src.SpeciesOfDogs.Dog;
import com.example.dog_selector.src.selection_options.Behavior_options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Controller
public class MainController {
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    static DogAcquisition dogAcquisition;

    static Scanner scan = new Scanner(System.in);

    static SelectedDog currentSelectedDog = null;
    static List<SelectedDog> selectedDogList = (List<SelectedDog>) Arrays.asList(
            new Akita_Inu(), new Beagle(), new Boxer(), new Bulldog(),
            new Chiwawa(), new Corgi(), new Dalmatian(), new Doberman(),
            new Haski(), new Labrador(), new Puddle(), new Pug(),
            new Samoed(), new Spitz(), new Tax());

        Dog dog = new Dog() {
            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public void display() {
            }

            @Override
            public String getDogSpeecy() {
                return "Corgi";
            }
        };



    @GetMapping()
    public String loginUser(@ModelAttribute("user") User user)
    {

        return "signup" ;
    }
    @PostMapping("/login")
    public String registration(@ModelAttribute("user")User user)
    {
        System.out.println(user);
       if(userService.login(user))
       {
           return "redirect:/dog_select/"+user.getId();
       }
       else {
           return "redirect:/login";
       }
    }
    @GetMapping("/registration")
    public String registerPage(@ModelAttribute("user")User user)
    {
        return "reg";
    }
    @PostMapping("/registration")
    public String saveUserInfo(@ModelAttribute("user")User user)
    {
        System.out.println(user.getFirstname() +" is logged in!");
        userService.register(user);

        return "redirect:dog_select/"+user.getId();
    }

    @GetMapping("/dog_select/{id}")
    public String dogSelect(@ModelAttribute("user")User user,
                            @ModelAttribute("behavior_options")Behavior_options behavior_options)
    {
        return "dog_select_page";
    }
    @PostMapping("/dog_select/{id}")
    public String findDogBreed(@ModelAttribute("behavior_options")Behavior_options behavior_options,
                               @PathVariable("id")Long id)


    {
        User user = userService.getUserById(id);

        switch (behavior_options.getMood()) {

            case "1" -> {
                dog.setMood("ACTIVE");

            }
            case "2" -> {
                dog.setMood("AGGRESSIVE");

            }
            case "3" -> {
                dog.setMood("CALM");

            }
        }
        switch (behavior_options.getSize()) {
            case "1" -> {
                dog.setSize("BIG");

            }
            case "2" -> {
                dog.setSize("MEDIUM");

            }
            case "3" -> {
                dog.setSize("SMALL");

            }
        }
        switch (behavior_options.getLifeStyle()) {
            case "1" -> {
                dog.setLifeStyle("STREET");

            }
            case "2" -> {
                dog.setLifeStyle("DOMESTIC");

            }
        }
        switch (behavior_options.getIntellect()) {
            case "1" -> {
                dog.setIntellect("TRAINED");

            }
            case "2" -> {
                dog.setIntellect("NOTRAINED");

            }}
        String speecyOfDog =  dog.defineTypeOfDog(dog);
        System.out.println("******************************************************");
        System.out.println("Message to Admin!");
        System.out.println(user.getFirstname()+ " wants "+ speecyOfDog +
                " what date dog will be available to pick up");
        System.out.println();
        String date = scan.next();
        Observer client = new Client(user.getFirstname(), speecyOfDog,date);
        clientService.addNewClient(client);
        for (SelectedDog selectedDog : selectedDogList) {
            if (selectedDog.description.equals(speecyOfDog)) {
                currentSelectedDog = selectedDog;
                break;
            }
        }





        return "redirect:/services/"+user.getId();
    }

    @GetMapping("/services/{id}")
    public String services(@PathVariable("id")Long id, Model model)
    {
        User user = userService.getUserById(id);
        BackClient client = clientService.findClientByName(user.getFirstname());

        model.addAttribute("user",user);
        model.addAttribute("backClient",client);
        return "other_services";
    }
    @PostMapping("/services/{id}")
    public String servicesForDog(@PathVariable("id")Long id, @RequestParam("deprivation")String deprivation,
                                 @RequestParam("vaccination")String vaccination)
    {
        User user = userService.getUserById(id);
        BackClient backClient = clientService.findClientByName(user.getFirstname());
        Client client = new Client(backClient.getDogBayer(),
                backClient.getDogSpeecy(),backClient.getDate());

        if (deprivation.equalsIgnoreCase("yes")) {
            currentSelectedDog = new DepRecFunc(currentSelectedDog);
        }
        if (vaccination.equalsIgnoreCase("yes")) {
            currentSelectedDog = new Grafted(currentSelectedDog);
        }
        clientService.setServicesAndItsCost(client,currentSelectedDog.getDescription(),currentSelectedDog.cost());
        return "redirect:/total_cost/"+user.getId();
    }

    @GetMapping("/total_cost/{id}")
    public String totalCost(@PathVariable("id")Long id,Model model)
    {
        User user =userService.getUserById(id);
        BackClient client = clientService.findClientByName(user.getFirstname());
        DescriptionOfDog descriptionOfDog = dog.getDescriptionOfDog(client.getDogSpeecy());
        String description = descriptionOfDog.getDescription();
        model.addAttribute("user",user);
        model.addAttribute("backClient",client);
        model.addAttribute("descriptionOfDog", description);



        return "total_cost_page";

    }





}
