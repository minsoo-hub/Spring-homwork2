package com.sparta.spring2.dto.schedule;

import com.sparta.spring2.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleUpdateContentsResponseDto {
    private final Long id;
    private final User user;
    private final String todoTitle;
    private final String todoContents;
    private final LocalDateTime modifiedAt;

    public ScheduleUpdateContentsResponseDto(Long id, User user, String todoTitle, String todoContents, LocalDateTime modifiedAt) {
        this.id = id;
        this.user = user;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
        this.modifiedAt = modifiedAt;
    }
}
