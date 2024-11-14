package com.example.agenda.service;

import com.example.agenda.dto.AuthorResponseDto;
import com.example.agenda.dto.SignUpResponseDto;
import com.example.agenda.entity.Author;
import com.example.agenda.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorSerivce {

    private final AuthorRepository authorRepository;

    public SignUpResponseDto signUp(String userName, String password, String email) {

        Author author = new Author(userName, password, email);
        Author savedAuthor = authorRepository.save(author);

        return new SignUpResponseDto(
                savedAuthor.getId(),
                savedAuthor.getUserName(),
                savedAuthor.getEmail(),
                savedAuthor.getCreatedAt(),
                savedAuthor.getModifiedAt()
        );
    }

    public AuthorResponseDto findAuthorById(Long id) {

        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if(optionalAuthor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id : " + id);
        }

        Author findAuthor = optionalAuthor.get();

        return new AuthorResponseDto(findAuthor.getUserName(), findAuthor.getEmail(), findAuthor.getCreatedAt(), findAuthor.getModifiedAt());
    }

    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        Author findAuthor = authorRepository.findByIdOrElseThrow(id);

        if (!findAuthor.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findAuthor.updatePassword(newPassword);
    }
}
