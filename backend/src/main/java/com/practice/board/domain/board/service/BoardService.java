package com.practice.board.domain.board.service;

import com.practice.board.domain.board.domain.Board;
import com.practice.board.domain.board.dto.mapper.BoardMapper;
import com.practice.board.domain.board.dto.request.BoardCreateRequestDto;
import com.practice.board.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    private final BoardMapper boardMapper;

    public Board create(BoardCreateRequestDto dto) {
        return boardRepository.save(boardMapper.toBoardEntity(dto));
    }

    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow();
    }
}
