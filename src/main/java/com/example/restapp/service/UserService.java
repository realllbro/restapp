package com.example.restapp.service;

import com.example.restapp.dao.UserRepository;
import com.example.restapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, String> getMessage() {
        return userRepository.getMessage();
    }


    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }


    public User getUserById(Integer userid) {
        return userRepository.getUserByUserid(userid);
    }


    public User registUser(User user) {
        return userRepository.insertUser(user);
    }


    public void modifyUser(Integer userid, User user) {
        user.setUserid(userid);
        userRepository.updateUser(user);
    }


    public void removeUser(Integer userid) {
        userRepository.deleteUser(userid);
    }

}
