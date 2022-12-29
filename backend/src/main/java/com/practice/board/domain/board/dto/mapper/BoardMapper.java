package com.practice.board.domain.board.dto.mapper;

import com.practice.board.domain.board.domain.Board;
import com.practice.board.domain.board.dto.request.BoardCreateRequestDto;
import com.practice.board.domain.board.dto.response.BasicBoardResponseDto;
import com.practice.board.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardMapper {

    private final UserRepository userRepository;

    public BasicBoardResponseDto toBoardResponseDto(Board entity) {
        return BasicBoardResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent()).build();
    }

    public Board toBoardEntity(BoardCreateRequestDto dto) {
        return Board.builder()
                .user(userRepository.findById(dto.getUserId()).orElseThrow(IllegalArgumentException::new))
                .title(dto.getTitle())
                .content(dto.getContent()).build();
    }
}
