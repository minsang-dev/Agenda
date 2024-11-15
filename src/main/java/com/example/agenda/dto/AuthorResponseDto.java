package com.example.agenda.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AuthorResponseDto {

    private final Long authorId;
    private final String userName;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public AuthorResponseDto(Long authorId, String userName, String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.authorId = authorId;
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;

    }

}
