package com.sparta.spring2.dto;

import lombok.Getter;

@Getter
public class CommentUpdateTextResponseDto {
    private final Long id;
    private final String userName;
    private final String text;

    public CommentUpdateTextResponseDto(Long id, String userName, String text) {
        this.id = id;
        this.userName = userName;
        this.text = text;
    }
}
