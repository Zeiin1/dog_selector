package com.example.dog_selector.src.Service;


import com.example.dog_selector.repository.UserRepository;

import com.example.dog_selector.src.Models.User;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    private boolean isLogin = false;
    private boolean adminIsLogin = false;

    public User login(User user)
    {
        User user1 = userRepository.findUserByLogin(user.getLogin());
      if(user1.getPassword().equals(user.getPassword()))
      {
          return user1;
      }
      else{
          return null;
      }

    }
    public void register(User user)
    {
        userRepository.save(user);
        this.isLogin = true;
    }
    public User getUser(User user)
    {
        return userRepository.findUserByFirstname(user.getFirstname());
    }
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

   /* public void sendMessageToAdmin(User user,String message)
    {
        User user1 = userRepository.findUserById(user.getId());
        user1.setMessages(message);*/

    public void setLoginStatement(boolean isLogin) {
        this.isLogin = isLogin;
    }
    public boolean getLoginStatement() {
        return this.isLogin;
    }

    public void setAdminIsLogin(boolean adminIsLogin) {
        this.adminIsLogin = adminIsLogin;
    }
    public boolean getAdminIsLogin() {
        return this.adminIsLogin;
    }


}
