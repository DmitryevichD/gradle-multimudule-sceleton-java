package ru.open.da.services.contract;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(RabbitAutoConfiguration.class)
public class ResourceAmqpContract {
    public static final String DEFAULT_RESOURCE_EXCHANGE_NAME = "service.resources";
    public static final String DEFAULT_RESOURCE_QUEUE_NAME = "service.resources.queue";
    public static final String DEFAULT_RESOURCE_ROUTING_KEY = "resourceKey";

    @Bean
    public Queue resourceQueue() {
        return new Queue(DEFAULT_RESOURCE_QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange resourceExchange() {
        return new DirectExchange(DEFAULT_RESOURCE_EXCHANGE_NAME);
    }

    @Bean
    public Binding resourceBinding(Queue updateParamsQueue, DirectExchange updateParamsExchange) {
        return BindingBuilder
                .bind(updateParamsQueue)
                .to(updateParamsExchange)
                .with(DEFAULT_RESOURCE_ROUTING_KEY);
    }

    @Bean("resourceAmqpMessageConverter")
    public MessageConverter getRabbitMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
