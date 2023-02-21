package com.projects.dogbreeds.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogsController {

    @GetMapping("/bark")
    public String bark() {
        return "Woof, woof!";
    }
}
