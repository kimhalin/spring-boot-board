package com.practice.board.domain.user.service;

import com.practice.board.domain.user.domain.User;
import com.practice.board.domain.user.dto.mapper.UserMapper;
import com.practice.board.domain.user.dto.request.UserCreateRequestDto;
import com.practice.board.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public User create(UserCreateRequestDto dto) {
        return userRepository.save(userMapper.toUserEntity(dto));
    }
}
