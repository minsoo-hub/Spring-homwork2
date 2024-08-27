package com.sparta.spring2.dto.schedule;

import com.sparta.spring2.entity.User;
import lombok.Getter;

@Getter
public class ScheduleSaveRequestDto {
    private User user;
    private String todoTitle;
    private String todoContents;
}
