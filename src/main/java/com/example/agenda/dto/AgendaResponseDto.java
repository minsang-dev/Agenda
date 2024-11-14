package com.example.agenda.dto;

import com.example.agenda.entity.Agenda;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AgendaResponseDto {

    private final Long id;
    private final String userName;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;

    public AgendaResponseDto(Long id, String userName, String title, String contents, LocalDateTime createdAt) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
    }

    public static AgendaResponseDto toDto(Agenda agenda) {
        return new AgendaResponseDto(agenda.getId(), agenda.getUserName(), agenda.getTitle(), agenda.getContents(),LocalDateTime.now());

    }
}
