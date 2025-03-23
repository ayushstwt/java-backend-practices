package com.ayshriv.cards.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class ErrorResponseDto {

    private String errorMessage;
    private LocalDateTime errorTime;
    private HttpStatus errorCode;
    private String apiPath;

}
