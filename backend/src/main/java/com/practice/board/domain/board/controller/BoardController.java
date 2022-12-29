package com.practice.board.domain.board.controller;

import com.practice.board.domain.board.dto.mapper.BoardMapper;
import com.practice.board.domain.board.dto.request.BoardCreateRequestDto;
import com.practice.board.domain.board.dto.response.BasicBoardResponseDto;
import com.practice.board.domain.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper boardMapper;

    @Tag(name = "BOARD API")
    @Operation(summary = "post board", description = "게시글 생성하기")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(implementation = BasicBoardResponseDto.class)))
    })
    @Parameters({
            @Parameter(name = "userId"),
            @Parameter(name = "title"),
            @Parameter(name = "content")
    })

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody BoardCreateRequestDto dto) {
        boardService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("success");
    }


    @GetMapping("/{id}")
    public ResponseEntity<BasicBoardResponseDto> getOne(@Valid @PathVariable Long id) {
        BasicBoardResponseDto response = boardMapper.toBoardResponseDto(boardService.findById(id));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<BasicBoardResponseDto>> getList(
            @PageableDefault(size = 20, sort = "createdOn", direction = Sort.Direction.DESC) final Pageable pageable
    ) {
        return ResponseEntity
                .ok(boardService.findAll(pageable).getContent());
    }
}
