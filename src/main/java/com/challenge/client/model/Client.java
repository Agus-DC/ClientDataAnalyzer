package com.challenge.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    String name;
    String surName;
    Integer age;
    @JsonProperty("born_date")
    ZonedDateTime bornDate;
}
