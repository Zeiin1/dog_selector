package com.example.dog_selector.src.Models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Array;
import java.util.List;

@Entity
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String role;
  /*  @ElementCollection
    private List<String> messages;*/
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String firstname, String lastname, String login, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
    }

    public User(String firstname, String lastname, String login, String password, Array messages) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;

    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

   /* public void setMessages(List<String> messages) {
        this.messages = messages;
    }*/

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

   /* public Array getMessages() {
        return (Array) this.messages;
    }*/

}
