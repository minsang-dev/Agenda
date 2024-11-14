package com.example.agenda.controller;

import com.example.agenda.dto.*;
import com.example.agenda.service.AuthorSerivce;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorSerivce authorSerivce;
    private HttpServletRequest authorService;

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

    // 전체조회
    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> findAll() {
        List<AuthorResponseDto> allAuthor = authorSerivce.findAll();
        return new ResponseEntity<>(allAuthor, HttpStatus.OK);
    }

    // 작성자 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> findAuthorById(@PathVariable Long id) {
        AuthorResponseDto authorResponseDto = authorSerivce.findAuthorById(id);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    // 작성자 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable Long id, @RequestBody DeleteAuthorRequestDto requestDto) {
        AuthorResponseDto deleteAuthor = authorSerivce.findAuthorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 로그인
    @GetMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto) {
        authorSerivce.login(requestDto);

        return ResponseEntity.ok().body(
                new LoginResponseDto(
                        requestDto.getEmail(),
                        requestDto.getPassword())
        );
    }

    // 로그아웃
    @GetMapping("/logout")
    public ResponseEntity<Object> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    // 비밀번호 변경
//    @PatchMapping("/{id}")
//    public ResponseEntity<Void> updatePassword(
//            @PathVariable Long id,
//            @RequestBody UpdatePasswordRequestDto requestDto
//    ) {
//        authorSerivce.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
