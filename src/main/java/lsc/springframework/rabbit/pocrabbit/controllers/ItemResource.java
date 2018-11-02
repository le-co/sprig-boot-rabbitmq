package lsc.springframework.rabbit.pocrabbit.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lsc.springframework.rabbit.pocrabbit.models.Items;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemResource {

    private RabbitTemplate rabbitTemplate;

    private TopicExchange topicExchange;

    public ItemResource(RabbitTemplate rabbitTemplate,@Qualifier("itemExchange") TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Items items) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String itemParser = mapper.writeValueAsString(items);
        rabbitTemplate.convertAndSend(topicExchange.getName(), "/", itemParser);
        return ResponseEntity.ok("{\"message\":\"ok\"}");
    }

    @GetMapping
    public ResponseEntity findOrder() {
        return ResponseEntity.ok("{\"message\":\"ok\"}");
    }
}
