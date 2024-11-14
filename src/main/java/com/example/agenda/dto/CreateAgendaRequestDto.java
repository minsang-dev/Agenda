package com.example.agenda.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateAgendaRequestDto {

    private final String userName;
    private final String title;
    private final String contents;

    public CreateAgendaRequestDto(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }
}
