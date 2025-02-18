package com.challenge.client.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {
    DATABASE_IS_EMPTY("No client data"),
    FAIL_TO_SAVE_CLIENT_ENTITY("Fail to save client entity"),
    FAIL_TO_SEND_CLIENT_DATA("Fail to send client data"),
    NO_CLIENT_DATA_AVAILABLE_TO_AVERAGE_AGE("No client data available to calculate average age"),
    NO_CLIENT_DATA_AVAILABLE_TO_STANDARD_DEVIATION("No client data available to calculate standard deviation age");

    private final String value;
}
