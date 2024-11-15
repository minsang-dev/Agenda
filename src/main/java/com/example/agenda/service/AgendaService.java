package com.example.agenda.service;

import com.example.agenda.dto.AgendaResponseDto;
import com.example.agenda.dto.UpdateAgendaRequestDto;
import com.example.agenda.entity.Agenda;
import com.example.agenda.entity.Author;
import com.example.agenda.repository.AgendaRepository;
import com.example.agenda.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final AuthorRepository authorRepository;
    private final AgendaRepository agendaRepository;

    // 일정 생성
    public AgendaResponseDto save(Long id, String userName, String title, String contents) {
        Author findAuthor = authorRepository.findByIdOrElseThrow(id);
        Agenda agenda = new Agenda(title, contents);
        agenda.setAuthor(findAuthor);

        Agenda savedAgenda = agendaRepository.save(agenda);

        return new AgendaResponseDto(
                savedAgenda.getId(),
                savedAgenda.getAuthor().getUserName(),
                savedAgenda.getTitle(),
                savedAgenda.getContents(),
                savedAgenda.getCreatedAt()
        );
    }
    
    // 일정 전체 조회
    public List<AgendaResponseDto> findAll() {

        return agendaRepository.findAll()
                .stream()
                .map(AgendaResponseDto::toDto)
                .toList();
    }

    // 특정 일정 조회
    public AgendaResponseDto findById(Long id) {
        return AgendaResponseDto.toDto(agendaRepository.findById(id).orElseThrow());
    }

    // 일정 수정
    public AgendaResponseDto update(Long id, UpdateAgendaRequestDto requestDto) {
        Agenda findAgenda = agendaRepository.findByIdOrElseThrow(id);
        findAgenda.updateAgenda(requestDto.getTitle(), requestDto.getContents());
        agendaRepository.save(findAgenda);

        return new AgendaResponseDto(
                findAgenda.getId(),
                findAgenda.getAuthor().getUserName(),
                findAgenda.getTitle(),
                findAgenda.getContents(),
                findAgenda.getModifiedAt()
        );
    }
    
    // 일정 삭제
    public void delete(Long id) {
        agendaRepository.delete (agendaRepository.findByIdOrElseThrow(id));
    }

}
