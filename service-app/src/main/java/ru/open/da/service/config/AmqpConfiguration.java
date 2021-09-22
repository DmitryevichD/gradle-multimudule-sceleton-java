package ru.open.da.service.config;

import lombok.val;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.open.da.service.contract.ResourceAmqpContract;

@Configuration
@Import(ResourceAmqpContract.class)
public class AmqpConfiguration {
//    @Bean
//    public MessageConverter messageConverter(ObjectMapper objectMapper) {
//        return RabbitApiConfiguration.getRabbitMessageConverter(objectMapper);
//    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter resourceAmqpMessageConverter) {
        val rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(resourceAmqpMessageConverter);
        return rabbitTemplate;
    }
}
