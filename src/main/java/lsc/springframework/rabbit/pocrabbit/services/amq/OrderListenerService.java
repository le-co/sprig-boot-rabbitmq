package lsc.springframework.rabbit.pocrabbit.services.amq;

import lsc.springframework.rabbit.pocrabbit.services.contracts.ListenerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderListenerService implements ListenerService {

    @RabbitListener(queues = "${order.queue}")
    public void receive(@Payload String fileBody) {
        System.out.println("Received < " + fileBody + ">");
    }
}
