package com.example.dog_selector.src.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Entity
@Data
@ToString
@Getter
@Setter
public class BackClient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dogBayer;
    private String dogSpeecy;
    private String date;
    private String description;
    private double cost;

    public BackClient( String dogBayer, String dogSpeecy, String date) {
        this.id = id;
        this.dogBayer = dogBayer;
        this.dogSpeecy = dogSpeecy;
        this.date = date;
    }

    public BackClient() {

    }
}
