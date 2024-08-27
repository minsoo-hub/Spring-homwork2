package com.sparta.spring2.service;

import com.sparta.spring2.dto.user.UserSaveRequestDto;
import com.sparta.spring2.dto.user.UserSaveResponseDto;
import com.sparta.spring2.dto.user.UserDetailResponseDto;
import com.sparta.spring2.dto.user.UserSimpleResponseDto;
import com.sparta.spring2.entity.User;
import com.sparta.spring2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponseDto saveUser(UserSaveRequestDto requestDto) {
        User user = new User(
                requestDto.getUserName(),
                requestDto.getEmail()
        );

        User newUser = userRepository.save(user);

        return new UserSaveResponseDto(
                newUser.getId(),
                newUser.getUserName(),
                newUser.getEmail(),
                newUser.getCreatedAt()
        );
    }


    public UserDetailResponseDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException("찾는 회원이 존재하지 않습니다."));

        return new UserDetailResponseDto(
                user.getId(),
                user.getUserName(),
                user.getEmail()
        );
    }

    public List<UserSimpleResponseDto> getAllUsers() {
        List<User> allUser = userRepository.findAll();

        List<UserSimpleResponseDto> dtoList = new ArrayList<>();

        for (User user : allUser) {
            UserSimpleResponseDto userDto = new UserSimpleResponseDto(
                    user.getUserName(),
                    user.getEmail());
            dtoList.add(userDto);
        }
        return dtoList;
    }

    public void deleteUser(Long usersId) {
        User user = userRepository.findById(usersId).orElseThrow(() -> new NullPointerException("삭제할 회원이 존재하지 않습니다."));

        userRepository.delete(user);
    }
}
