package lsc.springframework.rabbit.pocrabbit.services.contracts;

import org.springframework.messaging.handler.annotation.Payload;

public interface ListenerService {

    void receive(@Payload String message);
}
