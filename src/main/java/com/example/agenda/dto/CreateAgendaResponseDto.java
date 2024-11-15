package com.example.agenda.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateAgendaResponseDto {

    private final Long authorId;
    private final String userName;
    private final String title;
    private final String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public CreateAgendaResponseDto(Long authorId, String userName,String title, String contents, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.authorId = authorId;
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
