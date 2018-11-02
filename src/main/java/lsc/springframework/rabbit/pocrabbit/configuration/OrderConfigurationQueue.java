package lsc.springframework.rabbit.pocrabbit.configuration;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigurationQueue {

    @Value("${order.exchange}")
    private String exchange;

    @Value("${order.queue}")
    private String queue;

    @Value("${order.route}")
    private String route;

    @Bean("orderQueue")
    Queue orderQueue() {
        return new Queue(this.queue);
    }

    @Bean("orderExchange")
    TopicExchange orderExchange() {
        return new TopicExchange(this.exchange);
    }

    @Bean("orderBinding")
    Binding binding(@Qualifier("orderQueue") Queue queue, @Qualifier("orderExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(route);
    }
}
