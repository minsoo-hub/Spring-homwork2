package com.sparta.spring2.controller;

import com.sparta.spring2.dto.*;
import com.sparta.spring2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponseDto> saveSchedule(ScheduleSaveRequestDto scheduleSaveRequestDto) {
        return ResponseEntity.ok(scheduleService.saveSchedule(scheduleSaveRequestDto));

    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleDetailResponseDto> getSchedule(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(scheduleService.getSchedule(scheduleId));
    }

    @PutMapping("/schedules/{scheduleId}/todoTitle")
    public ResponseEntity<ScheduleUpdateTitleResponseDto> updateTodoTitle(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleUpdateTitleRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.updateTodoTitle(scheduleId, requestDto));
    }


    @PutMapping("/schedules/{scheduleId}/todoContents")
    public ResponseEntity<ScheduleUpdateContentsResponseDto> updateTodoContents(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleUpdateContentsRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.updateTodoContents(scheduleId, requestDto));
    }
}
