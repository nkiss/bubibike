package hu.bpbikes.bubidata.integration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegrationConfig {
	
	static final String BIKE_USAGE_EXCHANGE = "bike.usage.exchange";

	static final String BIKE_USAGE_QUEUE = "bike.usage.queue";
  
	static final String WEATHER_EXCHANGE = "weather.exchange";

	static final String WEATHER_QUEUE = "weather.queue";

    @Bean
    Queue weatherDataQueue() {
        return new Queue(WEATHER_QUEUE, true);
    }

    @Bean
    Queue bikeUsageDataQueue() {
        return new Queue(BIKE_USAGE_QUEUE, true);
    }
    
    @Bean
    TopicExchange bikeUsageExchange() {
    	return new TopicExchange(BIKE_USAGE_EXCHANGE);
    }
    
    @Bean
    TopicExchange weatherExchange() {
    	return new TopicExchange(WEATHER_EXCHANGE);
    }

    /*Binding weatherBinding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("weather.#");
    }*/
    
    @Bean
    Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

}
