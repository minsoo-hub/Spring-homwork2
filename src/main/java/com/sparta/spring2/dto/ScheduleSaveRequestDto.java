package com.sparta.spring2.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ScheduleSaveRequestDto {
    private String userName;
    private String todoTitle;
    private String todoContents;
}
