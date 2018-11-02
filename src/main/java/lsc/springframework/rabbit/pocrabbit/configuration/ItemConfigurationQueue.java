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
public class ItemConfigurationQueue {

    @Value("${item.exchange}")
    private String exchange;

    @Value("${item.queue}")
    private String queue;

    @Value("${item.route}")
    private String route;

    @Bean(name = "itemQueue")
    Queue queue() {
        return new Queue(queue, false);
    }

    @Bean(name = "itemExchange")
    TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean(name = "itemBinding")
    Binding binding(@Qualifier("itemQueue") Queue queue, @Qualifier("itemExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(route);
    }
}
