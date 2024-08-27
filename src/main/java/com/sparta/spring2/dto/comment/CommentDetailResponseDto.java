package com.sparta.spring2.dto.comment;

import lombok.Getter;

@Getter
public class CommentDetailResponseDto {
    private final Long id;
    private final String userName;
    private final String text;

    public CommentDetailResponseDto(Long id, String userName, String text) {
        this.id = id;
        this.userName = userName;
        this.text = text;
    }
}
