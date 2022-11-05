package com.example.dog_selector.controller;


import com.example.dog_selector.src.Decorator.DepRecFunc;
import com.example.dog_selector.src.Decorator.Grafted;
import com.example.dog_selector.src.Decorator.SelectedDog;
import com.example.dog_selector.src.Decorator.SelectodDogs.*;
import com.example.dog_selector.src.Models.BackClient;
import com.example.dog_selector.src.Models.Client;
import com.example.dog_selector.src.Models.Dogs;
import com.example.dog_selector.src.Models.User;
import com.example.dog_selector.src.Observer.DogAcquisition;
import com.example.dog_selector.src.Observer.Observer;
import com.example.dog_selector.src.Service.ClientServiceImpl;
import com.example.dog_selector.src.Service.DogsServiceImpl;
import com.example.dog_selector.src.Service.UserServiceImpl;
import com.example.dog_selector.src.SpeciesOfDogs.DescriptionOfDog;
import com.example.dog_selector.src.SpeciesOfDogs.Dog;
import com.example.dog_selector.src.SpeciesOfDogs.MostPopularDog;
import com.example.dog_selector.src.selection_options.Behavior_options;
import com.example.dog_selector.src.selection_options.ServicesForDog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @Autowired
    private DogsServiceImpl dogsService;

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
    public String indexPage()
    {return "index";
    }

    @GetMapping("/login")
    public String loginUser(@ModelAttribute("user") User user)
    {
        return "login" ;
    }

    @PostMapping("/login")
    public String registration(@ModelAttribute("user")User user)
    {

        User user1 = userService.login(user);

       if(user1 == null)
       {
           return "redirect:/login";

       }
       else {
           return "redirect:/dog_select/"+user1.getId();
       }
    }


    @GetMapping("/registration")
    public String registerPage(@ModelAttribute("user")User user)
    {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUserInfo(@ModelAttribute("user")User user)
    {
        userService.register(user);
        return "redirect:dog_select/"+user.getId();
    }

    @GetMapping("/dog_select/{id}")
    public String dogSelect(@ModelAttribute("user")User user,
                            @ModelAttribute("behavior_options")Behavior_options behavior_options,
                            Model model)
    {
       /* MostPopularDog mostPopularDog = MostPopularDog.getInstanceOfMostPopularDog();
        String popularDog = mostPopularDog.getSpeecyOfMostPopularDog();
        model.addAttribute("dog",popularDog);*/


        return "selector";
    }
    @RequestMapping(
            value = "/dog_select/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    public String findDogBreed(@ModelAttribute("behavior_options")Behavior_options behavior_options,
                               @PathVariable("id")Long id)


    {

        System.out.println(behavior_options);
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

        String speecyOfDogForDB =  dogsService.findDogSpeecy(dog.getSize(),dog.getMood(),
                dog.getIntellect(),dog.getLifeStyle());
        String speecyOfDog = dog.defineTypeOfDog(dog);
        String date = "14 days";
        Observer client = new Client(user.getFirstname(),speecyOfDogForDB,speecyOfDog,date);
        clientService.addNewClient(client);
        for (SelectedDog selectedDog : selectedDogList) {
            if (selectedDog.description.equals(speecyOfDog)) {
                currentSelectedDog = selectedDog;
                break;
            }
            else {
                currentSelectedDog = new Corgi();
            }
        }





        return "redirect:/services/"+user.getId();
    }

    @GetMapping("/services/{id}")
    public String services(@PathVariable("id")Long id, Model model,
                           @ModelAttribute("services_for_dog")ServicesForDog servicesForDog)
    {
       /* MostPopularDog mostPopularDog = MostPopularDog.getInstanceOfMostPopularDog();
        String popularDog = mostPopularDog.getSpeecyOfMostPopularDog();
        model.addAttribute("dog",popularDog);*/
        User user = userService.getUserById(id);
        BackClient client = clientService.findClientByName(user.getFirstname());

        model.addAttribute("user",user);
        model.addAttribute("backClient",client);
        return "services";
    }


    @PostMapping("/services/{id}")
    public String servicesForDog(@PathVariable("id")Long id,
                                 @ModelAttribute("services_for_dog")ServicesForDog servicesForDog)
    {
        System.out.println(servicesForDog);
        User user = userService.getUserById(id);
        BackClient backClient = clientService.findClientByName(user.getFirstname());

        Client client = new Client(backClient.getDogBayer(),backClient.getDogSpeecyForDB(),
                backClient.getDogSpeecy(),backClient.getDate());

        if (servicesForDog.getDeprivation().equalsIgnoreCase("yes")) {
            currentSelectedDog = new DepRecFunc(currentSelectedDog);
        }
        if (servicesForDog.getVaccination().equalsIgnoreCase("yes")) {
            currentSelectedDog = new Grafted(currentSelectedDog);
        }
        clientService.setServicesAndItsCost(client,currentSelectedDog.getDescription(),
                currentSelectedDog.cost());
        return "redirect:/total_cost/"+user.getId();
    }



    @GetMapping("/image/display/{speecyOfDog}")
    @ResponseBody
    void showImage(@PathVariable("speecyOfDog") String speecyOfDog, HttpServletResponse response,Dogs dogs)
            throws ServletException, IOException {

        dogs = dogsService.getDogBySpeecy(speecyOfDog);
        response.setContentType("image/png");
        response.getOutputStream().write(dogs.getData());
        response.getOutputStream().close();
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
        return "result";

    }



    @GetMapping("/save_dog")
    public String saveDogsPage(@ModelAttribute("dogs") Dogs dogs)
    {
        return "saveDogs";
    }

    @PostMapping("/save_dog")
    public String saveDogsToBD(@ModelAttribute("dogs")Dogs dogs, @RequestParam("file")MultipartFile file) throws IOException {
        dogs.setData(file.getBytes());

        dogsService.saveDog(dogs);
        return "redirect:/save_dog";
    }








}
