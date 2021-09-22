package ru.open.da.service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.open.da.service.api.ResourceRestApi;
import ru.open.da.service.api.impl.ResourceRestApiImpl;
import ru.open.da.service.feign.ResourceClient;
import ru.open.da.services.contract.ResourceAmqpContract;
import ru.open.da.services.model.message.ResourceMessage;

import static ru.open.da.services.contract.ResourceAmqpContract.DEFAULT_RESOURCE_EXCHANGE_NAME;

@Configuration
@Import(ResourceAmqpContract.class)
@AutoConfigureAfter(RabbitAutoConfiguration.class)
public class AmqpApiConfiguration {

    @Bean
    public ResourceMessage userParamsService(ConnectionFactory connectionFactory, ObjectMapper objectMapper) {
        val messageConverter = getRabbitMessageConverter(objectMapper);
        val rabbitTemplate = resourceRabbitTemplate(connectionFactory, messageConverter);
        return new AmqpApiConfiguration(rabbitTemplate, rabbitProperties);
    }



    private RabbitTemplate resourceRabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        val rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        rabbitTemplate.setExchange(DEFAULT_RESOURCE_EXCHANGE_NAME);
        return rabbitTemplate;
    }
}
