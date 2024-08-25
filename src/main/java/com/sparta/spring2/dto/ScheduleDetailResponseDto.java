package com.sparta.spring2.dto;

public class ScheduleDetailResponseDto {

    private final Long id;
    private final String userName;
    private final String todoTitle;
    private final String todoContents;

    public ScheduleDetailResponseDto(Long id, String userName, String todoTitle, String todoContents) {
        this.id = id;
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}
