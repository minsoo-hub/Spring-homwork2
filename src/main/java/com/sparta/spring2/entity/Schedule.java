package com.sparta.spring2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Schedule extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String todoTitle;
    private String todoContents;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.REMOVE)
    List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "schedule")
    List<ScheduleAndUser> scheduleAndUsers = new ArrayList<>();

    public Schedule(User user, String todoTitle, String todoContents) {
        this.user = user;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }

    public void updateTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public void updateContents(String todoContents) {
        this.todoContents = todoContents;
    }
}
