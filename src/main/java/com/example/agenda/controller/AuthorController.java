package com.example.agenda.controller;

import com.example.agenda.dto.AuthorResponseDto;
import com.example.agenda.dto.SignUpRequestDto;
import com.example.agenda.dto.SignUpResponseDto;
import com.example.agenda.dto.UpdatePasswordRequestDto;
import com.example.agenda.service.AuthorSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorSerivce authorSerivce;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                authorSerivce.signUp(
                        requestDto.getUserName(),
                        requestDto.getPassword(),
                        requestDto.getEmail()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    // 작성자 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> findAuthorById(@PathVariable Long id) {
        AuthorResponseDto authorResponseDto = authorSerivce.findAuthorById(id);

        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto requestDto
    ) {
        authorSerivce.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
