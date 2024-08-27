package com.sparta.spring2.controller;

import com.sparta.spring2.dto.user.UserSaveRequestDto;
import com.sparta.spring2.dto.user.UserSaveResponseDto;
import com.sparta.spring2.dto.user.UserDetailResponseDto;
import com.sparta.spring2.dto.user.UserSimpleResponseDto;
import com.sparta.spring2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserSaveResponseDto> saveUser(UserSaveRequestDto requestDto) {
        return ResponseEntity.ok(userService.saveUser(requestDto));
    }

    @GetMapping("/users/{usersId}")
    public ResponseEntity<UserDetailResponseDto> getUserById(@PathVariable Long usersId) {
        return ResponseEntity.ok(userService.getUserById(usersId));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserSimpleResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("users/{usersId}")
    public void deleteUser(@PathVariable Long usersId) {
        userService.deleteUser(usersId);
    }
}
