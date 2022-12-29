package com.practice.board.domain.board.service;

import com.practice.board.domain.board.domain.Board;
import com.practice.board.domain.board.dto.mapper.BoardMapper;
import com.practice.board.domain.board.dto.request.BoardCreateRequestDto;
import com.practice.board.domain.board.dto.response.BasicBoardResponseDto;
import com.practice.board.domain.board.repository.BoardRepository;
import com.practice.board.domain.user.domain.User;
import com.practice.board.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    private final BoardMapper boardMapper;

    @PostConstruct
    public void init() {
        User user = userRepository.save(User.builder().email("test@naver.com").name("test").nickname("test").build());
        for (int i = 1; i <= 25; ++i) {
            boardRepository.save(Board.builder().title("제목" + i).content("내용" + i).user(user).build());
        }
    }

    public Board create(BoardCreateRequestDto dto) {
        return boardRepository.save(boardMapper.toBoardEntity(dto));
    }

    @Transactional(readOnly = true)
    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public Page<BasicBoardResponseDto> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable).map(boardMapper::toBoardResponseDto);
    }
}
