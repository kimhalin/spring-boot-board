package com.practice.board.domain.user.controller;

import com.practice.board.domain.user.domain.User;
import com.practice.board.domain.user.dto.mapper.UserMapper;
import com.practice.board.domain.user.dto.request.UserCreateRequestDto;
import com.practice.board.domain.user.dto.response.BasicUserResponseDto;
import com.practice.board.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<BasicUserResponseDto> create(@Valid @RequestBody UserCreateRequestDto dto) {
        User entity = userService.create(dto);
        BasicUserResponseDto response = userMapper.toUserResponseDto(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
