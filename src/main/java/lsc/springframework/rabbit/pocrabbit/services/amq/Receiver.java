package lsc.springframework.rabbit.pocrabbit.services.amq;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public void receive(String fileBody) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Received < " + fileBody + ">");
    }

}
