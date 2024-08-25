package com.sparta.spring2.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateContentsResponseDto {
    private final Long id;
    private final String userName;
    private final String todoTitle;
    private final String todoContents;

    public ScheduleUpdateContentsResponseDto(Long id, String userName, String todoTitle, String todoContents) {
        this.id = id;
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
