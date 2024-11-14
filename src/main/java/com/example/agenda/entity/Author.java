package com.example.agenda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@Table(name = "author")
@EntityListeners(AuditingEntityListener.class)
public class Author extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 25)
    private String userName;

    @Column(name = "password", nullable = false, length = 25)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    public Author() {}

    public Author(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

}
