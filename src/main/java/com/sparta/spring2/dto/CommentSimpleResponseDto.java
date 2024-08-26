package com.sparta.spring2.dto;

import lombok.Getter;

@Getter
public class CommentSimpleResponseDto {

    private final String text;

    public CommentSimpleResponseDto(String text) {
        this.text = text;
    }
}
