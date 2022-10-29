package com.example.dog_selector.src.Models;


import com.example.dog_selector.src.Observer.Observer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Getter
@Setter
public class Client implements Observer {

    private Long id;
    private String dogBayer;
    private String dogSpeecy;
    private String date;
    private String description;
    private String dogSpeecyForDB;
    private double cost;

    public Client() {}

    public Client(String dogBayer,String dogSpeecyForDB, String dogSpeecy, String date) {
        this.dogBayer = dogBayer;
        this.dogSpeecy = dogSpeecy;
        this.date = date;
        this.dogSpeecyForDB = dogSpeecyForDB;
    }

    @Override
    public void update() {
        System.out.println(this.dogBayer + " is waiting for " +
                this.dogSpeecy + ", date to pickup is: " + this.date);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String getName() {
        return getDogBayer();
    }

    @Override
    public String getDogBreed() {
        return getDogSpeecy();
    }

    public String getDogBayer() {
        return this.dogBayer;
    }

    public String getDogSpeecy() { return this.dogSpeecy; }

    public String getDate() { return this.date; }
}
