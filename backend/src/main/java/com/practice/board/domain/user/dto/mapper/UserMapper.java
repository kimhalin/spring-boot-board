package com.practice.board.domain.user.dto.mapper;

import com.practice.board.domain.user.domain.User;
import com.practice.board.domain.user.dto.request.UserCreateRequestDto;
import com.practice.board.domain.user.dto.response.BasicUserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public BasicUserResponseDto toUserResponseDto(User entity) {
       return BasicUserResponseDto.builder()
               .id(entity.getId())
               .name(entity.getName())
               .email(entity.getEmail())
               .nickname(entity.getNickname())
               .build();
    }

    public User toUserEntity(UserCreateRequestDto dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .build();
    }

}
