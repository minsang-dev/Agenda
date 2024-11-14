package com.example.agenda.dto;

import lombok.Getter;

@Getter
public class UpdateAgendaRequestDto {

    private final Long author_id;
    private final String title;
    private final String contents;
    private final String password;

    public UpdateAgendaRequestDto(Long author_id, String title, String contents, String password) {
        this.author_id = author_id;
        this.title = title;
        this.contents = contents;
        this.password = password;
    }

}
