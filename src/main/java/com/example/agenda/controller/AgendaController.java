package com.example.agenda.controller;


import com.example.agenda.dto.AgendaResponseDto;
import com.example.agenda.dto.CreateAgendaRequestDto;
import com.example.agenda.dto.UpdateAgendaRequestDto;
import com.example.agenda.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaService agendaService;

    // 일정 생성
    @PostMapping("/{author_id}")
    public ResponseEntity<AgendaResponseDto> save(@PathVariable Long author_id, @RequestBody CreateAgendaRequestDto requestDto) {

        AgendaResponseDto agendaResponseDto =
                agendaService.save(
                        author_id,
                        requestDto.getUserName(),
                        requestDto.getTitle(),
                        requestDto.getContents()
                );

        return new ResponseEntity<>(agendaResponseDto, HttpStatus.CREATED);
    }

    // 전체 일정 조회
    @GetMapping("/agendas")
    public ResponseEntity<List<AgendaResponseDto>> findAll() {
        List<AgendaResponseDto> allAgenda = agendaService.findAll();
        return new ResponseEntity<>(allAgenda, HttpStatus.OK);
    }

    // 특정 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<AgendaResponseDto> findById(@PathVariable Long id) {
        AgendaResponseDto agenda = agendaService.findById(id);
        return new ResponseEntity<>(agenda, HttpStatus.OK);
    }

    // 일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<AgendaResponseDto> update(@PathVariable Long id, @RequestBody UpdateAgendaRequestDto requestDto) {
        AgendaResponseDto updateAgenda = agendaService.update(requestDto);
        return new ResponseEntity<>(updateAgenda, HttpStatus.OK);
    }

    // 일정 삭제
    @DeleteMapping("/agendas/{id}")
    public ResponseEntity<AgendaResponseDto> delete(@PathVariable Long id) {
        agendaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
