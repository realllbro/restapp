package com.example.restapp.controller;

import com.example.restapp.model.User;
import com.example.restapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userid}")    //{변수명}
    public User getUserByUserid(@PathVariable Integer userid) {
        System.out.println(userid);
        return userService.getUserById(userid);
    }

    @PostMapping("")
    public User registUser(@RequestBody User user) {
        //@RequestBody 로 받으면 파퓰레이션 ?? http body를 바로 받으며, User 필드명과 같으면 자동으로 파싱해 준다.
        return userService.registUser(user);
    }

    @PutMapping("/{userid}")
    public void modifyUser(@PathVariable Integer userid,
                           @RequestBody User user) {
        user.setUserid(userid);
        userService.modifyUser(userid, user);
    }

    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable Integer userid) {
        userService.removeUser(userid);
    }


}
