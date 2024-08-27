package com.sparta.spring2.dto.comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSaveResponseDto {
    private final Long Id;
    private final String userName;
    private final String text;
    private final LocalDateTime createdAt;

    public CommentSaveResponseDto(Long id, String userName, String text, LocalDateTime createdAt) {
        this.Id = id;
        this.userName = userName;
        this.text = text;
        this.createdAt = createdAt;

    }
}
