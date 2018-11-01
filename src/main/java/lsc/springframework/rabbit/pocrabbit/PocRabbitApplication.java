package lsc.springframework.rabbit.pocrabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class PocRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocRabbitApplication.class, args);
	}
}
