package com.example.dog_selector.src.Models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Dogs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String size;
    private String intellect;
    private String mood;
    private String lifeStyle;
    private String dogSpeecy;
    @Lob
    private byte [] data;


}
