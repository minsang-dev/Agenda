package com.example.agenda.dto;

public class LoginResponseDto {
    private final String userName;
    private final String email;

    public LoginResponseDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
