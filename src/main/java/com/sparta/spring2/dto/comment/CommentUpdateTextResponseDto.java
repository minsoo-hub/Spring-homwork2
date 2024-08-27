package com.sparta.spring2.dto.comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentUpdateTextResponseDto {
    private final Long id;
    private final String userName;
    private final String text;
    private final LocalDateTime modifiedAt;

    public CommentUpdateTextResponseDto(Long id, String userName, String text, LocalDateTime modifiedAt) {
        this.id = id;
        this.userName = userName;
        this.text = text;
        this.modifiedAt = modifiedAt;
    }
}
