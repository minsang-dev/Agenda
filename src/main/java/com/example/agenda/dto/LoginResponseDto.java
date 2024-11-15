package com.example.agenda.dto;

import lombok.Getter;

@Getter

public class LoginResponseDto {
    private final String userName;
    private final String email;

    public LoginResponseDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
