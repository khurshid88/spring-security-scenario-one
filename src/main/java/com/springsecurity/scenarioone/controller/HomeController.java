package com.springsecurity.scenarioone.controller;

import com.springsecurity.scenarioone.model.CustomResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {
    @GetMapping("/home")
    public CustomResponse home() {
        return CustomResponse.successMsg("Welcome to home");
    }
}
