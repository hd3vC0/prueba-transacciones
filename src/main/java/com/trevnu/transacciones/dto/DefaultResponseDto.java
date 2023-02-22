package com.trevnu.transacciones.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class DefaultResponseDto {
    private Integer statusCode;
    private String message;
    private Object data;
}
