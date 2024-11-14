package com.example.agenda.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignUpResponseDto {

    private final Long id;
    private final String userName;
    private final String email;
    LocalDateTime createdAt;
    LocalDateTime modifiedAt;

    public SignUpResponseDto(Long id, String userName, String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.userName = userName;
        this.email = email;

        LocalDateTime now = LocalDateTime.now();
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
