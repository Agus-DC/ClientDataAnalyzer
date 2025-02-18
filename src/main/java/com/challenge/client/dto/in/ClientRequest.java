package com.challenge.client.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    @NotEmpty(message = "Name may not be empty")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    String name;

    @NotEmpty(message = "Name may not be empty")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    String surname;

    @Min(value = 1, message = "Age should not be less than 1")
    @Max(value = 150, message = "Age should not be greater than 150")
    Integer age;

    @NotNull(message = "Born date not be null")
    @JsonProperty("born_date")
    ZonedDateTime bornDate;
}
