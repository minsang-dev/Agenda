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

    @Column(name = "user_name", nullable = false, length = 25)
    private String userName;

    @Column(name = "title", nullable = false, length = 25)
    private String title;

    @Column(name = "contents", nullable = false, length = 50)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Agenda() {
    }

    public Agenda(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }

    public void updateAgenda(Author author, String title, String contents) {
        this.author = author;
        this.title = title;
        this.contents = contents;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
