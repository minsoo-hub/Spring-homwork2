package com.sparta.spring2.dto.schedule;

import com.sparta.spring2.entity.User;

public class ScheduleDetailResponseDto {

    private final Long id;
    private final User user;
    private final String todoTitle;
    private final String todoContents;

    public ScheduleDetailResponseDto(Long id, User user, String todoTitle, String todoContents) {
        this.id = id;
        this.user = user;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
