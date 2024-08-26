package com.sparta.spring2.service;

import com.sparta.spring2.dto.*;
import com.sparta.spring2.entity.Schedule;
import com.sparta.spring2.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveResponseDto saveSchedule(ScheduleSaveRequestDto scheduleSaveRequestDto) {
        Schedule schedule = new Schedule(
                scheduleSaveRequestDto.getUserName(),
                scheduleSaveRequestDto.getTodoTitle(),
                scheduleSaveRequestDto.getTodoContents()
        );

        Schedule newSchedule = scheduleRepository.save(schedule);

        return new ScheduleSaveResponseDto(
                newSchedule.getId(),
                newSchedule.getUserName(),
                newSchedule.getTodoTitle(),
                newSchedule.getTodoContents()
        );
    }


    public ScheduleDetailResponseDto getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NullPointerException("스케줄 못찾았습니다."));

        return new ScheduleDetailResponseDto(
                schedule.getId(),
                schedule.getUserName(),
                schedule.getTodoTitle(),
                schedule.getTodoContents()
        );


    }

    @Transactional
    public ScheduleUpdateTitleResponseDto updateTodoTitle(
            Long scheduleId,
            ScheduleUpdateTitleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NullPointerException("수정할 일정이 없습니다"));

        schedule.updateTitle(requestDto.getTodoTitle());

        return new ScheduleUpdateTitleResponseDto(
                schedule.getId(),
                schedule.getUserName(),
                schedule.getTodoTitle(),
                schedule.getTodoContents()
        );


    }

    @Transactional
    public ScheduleUpdateContentsResponseDto updateTodoContents(
            Long scheduleId,
            ScheduleUpdateContentsRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NullPointerException("수정할 일정이 없습니다."));

        schedule.updateContents(requestDto.getTodoContents());

        return new ScheduleUpdateContentsResponseDto(
                schedule.getId(),
                schedule.getUserName(),
                schedule.getTodoTitle(),
                schedule.getTodoContents()
        );

    }
}
