package com.sparta.spring2.service;

import com.sparta.spring2.dto.*;
import com.sparta.spring2.entity.Comment;
import com.sparta.spring2.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(CommentSaveRequestDto requestDto) {
        Comment comment = new Comment(
                requestDto.getUserName(),
                requestDto.getText()
        );

        Comment newComment = commentRepository.save(comment);

        return new CommentSaveResponseDto(
                newComment.getId(),
                newComment.getUserName(),
                newComment.getText()
        );
    }

    public CommentDetailResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NullPointerException("찾을 댓글 없음"));

        return new CommentDetailResponseDto(
                comment.getId(),
                comment.getUserName(),
                comment.getText()
        );
    }

    public List<CommentSimpleResponseDto> getAllComments() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();

        for (Comment comment : commentList) {
            CommentSimpleResponseDto dto = new CommentSimpleResponseDto(comment.getText());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional
    public CommentUpdateTextResponseDto updateText(
            Long commentId,
            CommentUpdateTextRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NullPointerException("수정할 댓글이 없습니다."));

        comment.updateText(requestDto.getText());

        return new CommentUpdateTextResponseDto(
                comment.getId(),
                comment.getUserName(),
                comment.getText()
        );
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NullPointerException("삭제할 댓글이 없습니다."));

        commentRepository.delete(comment);
    }
}
