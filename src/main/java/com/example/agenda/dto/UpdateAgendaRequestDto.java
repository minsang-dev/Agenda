package com.example.agenda.dto;

import lombok.Getter;

@Getter
public class UpdateAgendaRequestDto {

    private final String title;
    private final String contents;
    private final String password;

    public UpdateAgendaRequestDto(String title, String contents, String password) {
        this.title = title;
        this.contents = contents;
        this.password = password;
    }

}
