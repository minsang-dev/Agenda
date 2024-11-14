package com.example.agenda.repository;

import com.example.agenda.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    default Author findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Does not exist id = " + id
                        )
                );

    }
}
