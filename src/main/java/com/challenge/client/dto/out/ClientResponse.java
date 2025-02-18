package com.challenge.client.dto.out;

import lombok.*;

import java.time.ZonedDateTime;

@Builder
@AllArgsConstructor
@Getter
public class ClientResponse {

    private String name;

    private String surname;

    private Integer age;

    private ZonedDateTime bornDate;

    private Integer lifeExpectancy;
}