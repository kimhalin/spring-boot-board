package com.practice.board.domain.board.repository;

import com.practice.board.domain.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> getBoardById(Long id);

}
