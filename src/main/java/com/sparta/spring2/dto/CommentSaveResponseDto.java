package com.sparta.spring2.dto;

import lombok.Getter;

@Getter
public class CommentSaveResponseDto {
    private final Long Id;
    private final String userName;
    private final String text;

    public CommentSaveResponseDto(Long id, String userName, String text) {
        Id = id;
        this.userName = userName;
        this.text = text;
    }
}
