package com.ayshriv.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
    private String statusCode;
    private String statusMessage;
    private T body;
}
