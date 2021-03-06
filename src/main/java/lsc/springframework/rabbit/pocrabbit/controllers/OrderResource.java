package lsc.springframework.rabbit.pocrabbit.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lsc.springframework.rabbit.pocrabbit.models.Order;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderResource {

    private RabbitTemplate rabbitTemplate;

    private TopicExchange topicExchange;

    public OrderResource(RabbitTemplate rabbitTemplate, @Qualifier("orderExchange") TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Order order) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String orderParser = mapper.writeValueAsString(order);
        rabbitTemplate.convertAndSend(topicExchange.getName(), "/", orderParser);
        return ResponseEntity.ok("{\"message\":\"ok\"}");
    }

    @GetMapping
    public ResponseEntity findOrder() {
        return ResponseEntity.ok("{\"message\":\"ok\"}");
    }

}
