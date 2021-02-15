package com.ironhack.helloworldservice.controller.dto;

public class UserEmailDTO {
    private Long id;
    private String email;

    public UserEmailDTO() {
    }

    public UserEmailDTO(Long id, String email, String xx) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
