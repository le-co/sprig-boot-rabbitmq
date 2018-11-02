package lsc.springframework.rabbit.pocrabbit.services.amq;

import lsc.springframework.rabbit.pocrabbit.services.contracts.ListenerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ItemListenerService implements ListenerService {

    @RabbitListener(queues = "${item.queue}")
    @Override
    public void receive(String message) {
        System.out.println(message);
    }
}
