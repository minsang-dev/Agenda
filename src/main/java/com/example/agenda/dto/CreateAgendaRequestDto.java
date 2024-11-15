package com.example.agenda.dto;

import lombok.Getter;

@Getter
public class CreateAgendaRequestDto {

    private final Long authorId;
    private final String userName;
    private final String title;
    private final String contents;

    public CreateAgendaRequestDto(Long authorId, String userName, String title, String contents) {
        this.authorId = authorId;
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }
}
