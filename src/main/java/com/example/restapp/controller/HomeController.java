package com.example.restapp.controller;

import com.example.restapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")    //Root 요청에 대응하는 컨트롤러
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public Map<String, String> home(){
        Map<String, String> res = this.userService.getMessage();
        return res;
    }
}
