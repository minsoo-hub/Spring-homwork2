package com.sparta.spring2.dto.user;

import lombok.Getter;

@Getter
public class UserSimpleResponseDto {
    private final String username;
    private final String email;

    public UserSimpleResponseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
