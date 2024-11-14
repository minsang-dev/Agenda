package com.example.agenda.repository;

import com.example.agenda.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // email로 Author 조회
    Optional<Author> findAuthorByEmail(String email);

    // ID로 Author 조회 -> 존재하지 않으면 예외 발생
    default Author findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "사용자를 찾을 수 없습니다."
                        )
                );

    }
}
