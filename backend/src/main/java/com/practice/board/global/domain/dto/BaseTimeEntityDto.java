package com.practice.board.global.domain.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

public abstract class BaseTimeEntityDto {

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;
}
