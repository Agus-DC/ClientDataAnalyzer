package com.challenge.client.service.mocks;

import com.challenge.client.dto.in.ClientRequest;
import java.time.ZonedDateTime;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientRequestMother {
    public ClientRequest getPaymentRequest() {
        return ClientRequest.builder()
                .name("pepe")
                .surname("pipon")
                .age(19)
                .bornDate(ZonedDateTime.parse("2016-08-22T14:30+08:00"))
                .build();
    }
}
