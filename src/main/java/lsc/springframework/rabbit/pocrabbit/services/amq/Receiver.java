package lsc.springframework.rabbit.pocrabbit.services.amq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "${leco.mq.queue}")
    public void receive(@Payload String fileBody) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Received < " + fileBody + ">");
    }

}
