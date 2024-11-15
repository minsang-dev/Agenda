package com.example.agenda.service;

import com.example.agenda.dto.AuthorResponseDto;
import com.example.agenda.dto.LoginRequestDto;
import com.example.agenda.dto.SignUpResponseDto;
import com.example.agenda.entity.Author;
import com.example.agenda.repository.AuthorRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorSerivce {

    private final AuthorRepository authorRepository;
    
    // 회원가입 메서드
    public SignUpResponseDto signUp(String userName, String password, String email) {

        Author author = new Author(userName, password, email);
        Author savedAuthor = authorRepository.save(author);

        return new SignUpResponseDto(
                savedAuthor.getId(),
                savedAuthor.getUserName(),
                savedAuthor.getEmail(),
                savedAuthor.getCreatedAt()
        );
    }
    
    // 전체 조회 메서드
    public List<AuthorResponseDto> findAll() {
        List<AuthorResponseDto> authorResponseDtoList = new ArrayList<>();

        List<Author> authorList = authorRepository.findAll();
        for (Author author : authorList) {
            AuthorResponseDto authorResponseDto = new AuthorResponseDto(
                    author.getId(),
                    author.getUserName(),
                    author.getEmail(),
                    author.getCreatedAt(),
                    author.getModifiedAt()
            );
            authorResponseDtoList.add(authorResponseDto);
        }
        return authorResponseDtoList;
    }
    
    // 특정 조회 메서드
    public AuthorResponseDto findAuthorById(Long id) {

        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if(optionalAuthor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id : " + id);
        }
        Author findAuthor = optionalAuthor.get();

        return new AuthorResponseDto(
                findAuthor.getId(),
                findAuthor.getUserName(), 
                findAuthor.getEmail(), 
                findAuthor.getCreatedAt(),
                findAuthor.getModifiedAt()
        );
    }

    // id 값 가져와서 삭제
    public void DeleteAuthorResponse(Long id) {
        authorRepository.delete(authorRepository.findByIdOrElseThrow(id));
    }

    // 로그인

    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "";
    }
    
    // 비밀번호 변경
    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        Author findAuthor = authorRepository.findByIdOrElseThrow(id);

        if (!findAuthor.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        findAuthor.updatePassword(newPassword);
    }

    public Author login(LoginRequestDto requestDto) {
        Author author = authorRepository.findByEmail(requestDto.getEmail()).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "사용자를 찾을 수 없습니다."
                )
        );

        if(!author.getPassword().equals(requestDto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 올바르지 않습니다.");
        }
        return author;

    }
}
