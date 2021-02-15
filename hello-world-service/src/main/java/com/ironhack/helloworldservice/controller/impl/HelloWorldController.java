package com.ironhack.helloworldservice.controller.impl;

import com.ironhack.helloworldservice.controller.dto.UserDTO;
import com.ironhack.helloworldservice.controller.dto.UserEmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello-world")
    public String helloWorld() {

        RestTemplate restTemplate = new RestTemplate();

        String url = discoveryClient.getInstances("world-service").get(0).getUri().toString() + "/world";

        return "Hello " + restTemplate.getForObject(url, String.class);
    }


    @GetMapping("/user")
    public UserDTO getUser() {

        RestTemplate restTemplate = new RestTemplate();

        String url = discoveryClient.getInstances("world-service").get(0).getUri().toString() + "/email";

        UserDTO userDTO = new UserDTO(1L, "vcardozo", null);

        UserEmailDTO userEmailDTO = restTemplate.getForObject(url, UserEmailDTO.class);

        userDTO.setEmail(userEmailDTO.getEmail());

        return userDTO;
    }

}
