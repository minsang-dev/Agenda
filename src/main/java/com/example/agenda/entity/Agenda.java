package com.example.agenda.entity;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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


}
