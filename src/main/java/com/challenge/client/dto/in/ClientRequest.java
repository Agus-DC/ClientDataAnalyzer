package com.challenge.client.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    String name;
    String surname;
    Integer age;
    @JsonProperty("born_date")
    ZonedDateTime bornDate;
}
