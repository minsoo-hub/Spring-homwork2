package com.sparta.spring2.controller;

import com.sparta.spring2.dto.*;
import com.sparta.spring2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment(CommentSaveRequestDto requestDto) {
        return ResponseEntity.ok(commentService.saveComment(requestDto));
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentDetailResponseDto> getComment(@PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.getComment(commentId));
    }

    @GetMapping("comments")
    public ResponseEntity<List<CommentSimpleResponseDto>> getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @PutMapping("comments/{commentId}/text")
    public ResponseEntity<CommentUpdateTextResponseDto> updateText(
            @PathVariable Long commentId,
            @RequestBody CommentUpdateTextRequestDto requestDto) {
        return ResponseEntity.ok(commentService.updateText(commentId, requestDto));
    }

    @DeleteMapping("comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}
