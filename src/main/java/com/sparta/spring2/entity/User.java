package com.sparta.spring2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class User extends Timestamped{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;

    @OneToMany(mappedBy = "user")
    List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<ScheduleAndUser> scheduleAndUsers = new ArrayList<>();

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
