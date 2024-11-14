package com.example.agenda.dto;

import lombok.Getter;

@Getter
public class DeleteAuthorRequestDto {

    private final String password;

    public DeleteAuthorRequestDto(String password) {
        this.password = password;
    }
}
