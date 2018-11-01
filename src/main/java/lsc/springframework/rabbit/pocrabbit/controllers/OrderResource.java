package lsc.springframework.rabbit.pocrabbit.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lsc.springframework.rabbit.pocrabbit.models.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderResource {

    private RabbitTemplate rabbitTemplate;

    @Value("${leco.mq.exchange}")
    private String exchange;

    @Value("${leco.mq.queue}")
    private String queue;

    @Value("${leco.mq.route}")
    private String route;

    @Autowired
    public OrderResource(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Order order) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String orderParser = mapper.writeValueAsString(order);
        rabbitTemplate.convertAndSend(this.exchange, this.route, orderParser);
        return ResponseEntity.ok("{\"message\":\"ok\"}");
    }

    @GetMapping
    public ResponseEntity findOrder() {
        return ResponseEntity.ok("{\"message\":\"ok\"}");
    }

}
