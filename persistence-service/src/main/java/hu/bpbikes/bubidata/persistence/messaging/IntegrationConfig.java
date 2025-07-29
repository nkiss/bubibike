package hu.bpbikes.bubidata.persistence.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
@Profile("!test")
public class IntegrationConfig {
	
	private static final Logger log = LoggerFactory.getLogger(IntegrationConfig.class);
	
	static final String BIKE_USAGE_EXCHANGE = "bike.usage.exchange";

	static final String BIKE_USAGE_QUEUE = "bike.usage.queue";
	
	static final String BIKE_USAGE_ROUTING_KEY = "bike.usage.data";
  
	static final String WEATHER_EXCHANGE = "weather.exchange";

	static final String WEATHER_QUEUE = "weather.queue";
	
	static final String WEATHER_ROUTING_KEY = "weather.data";

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

    @Bean
    Binding weatherBinding(
    		@Qualifier("weatherDataQueue") Queue queue, 
    		@Qualifier("weatherExchange") TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("weather.#");
    }
    
    @Bean
    Binding bikeUsageBinding(
    		@Qualifier("bikeUsageDataQueue") Queue queue, 
    		@Qualifier("bikeUsageExchange") TopicExchange topicExchange) {
    	return BindingBuilder.bind(queue).to(topicExchange).with("bike.usage.#");
    }
    
    @Bean
    Jackson2JsonMessageConverter messageConverter() {
    	ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

}
