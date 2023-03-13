package com.springsecurity.scenarioone.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomResponse {
    private String message;
    private Boolean success;
    private Object data;
    private Object error;

    public static CustomResponse successMsg() {
        return CustomResponse
                .builder()
                .message("success")
                .success(true)
                .build();
    }

    public static CustomResponse successMsg(Object data) {
        return CustomResponse
                .builder()
                .message("success")
                .success(true)
                .data(data)
                .build();
    }

    public static CustomResponse errorMsg(Object error) {
        return CustomResponse
                .builder()
                .message("error")
                .success(false)
                .error(error)
                .build();
    }
}
