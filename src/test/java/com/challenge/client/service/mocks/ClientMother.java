package com.challenge.client.service.mocks;

import com.challenge.client.model.Client;
import java.time.ZonedDateTime;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientMother {
    public Client getClient() {
        return Client.builder()
                .name("pepe")
                .surname("pipon")
                .age(19)
                .bornDate(ZonedDateTime.parse("2016-08-22T14:30+08:00"))
                .build();
    }
}
