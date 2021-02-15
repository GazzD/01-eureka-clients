package com.ironhack.worldservice.controller.impl;

import com.ironhack.worldservice.controller.dto.UserEmailDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    @GetMapping("/world")
    public String world() {
        return "World D:";
    }

    @GetMapping("/email")
    public UserEmailDTO getUserEmail() {
        return new UserEmailDTO(1L, "vcardozof@gmail.com");
    }

}
