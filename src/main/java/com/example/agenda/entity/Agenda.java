package com.example.agenda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@Table(name = "agenda")
@EntityListeners(AuditingEntityListener.class)
public class Agenda extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 25)
    private String title;

    @Column(name = "contents", nullable = false, length = 50)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    public Agenda(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Agenda() {

    }

    public void updateAgenda(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
