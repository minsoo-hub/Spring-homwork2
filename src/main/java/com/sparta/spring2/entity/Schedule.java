package com.sparta.spring2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String todoTitle;
    private String todoContents;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.REMOVE)
    List<Comment> comments = new ArrayList<>();

    public Schedule(String userName, String todoTitle, String todoContents) {
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
        LocalDateTime now = LocalDateTime.now();
        this.createAt = now;
        this.updateAt = now;
    }

    public void updateTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public void updateContents(String todoContents) {
        this.todoContents = todoContents;
    }
}
