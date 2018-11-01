package lsc.springframework.rabbit.pocrabbit.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {

    @Value("${leco.mq.exchange}")
    private String exchange;

    @Value("${leco.mq.queue}")
    private String queue;

    @Value("${leco.mq.route}")
    private String route;

    @Bean
    Queue queue() {
        return new Queue(this.queue, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(this.exchange);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(this.route);
    }
}
