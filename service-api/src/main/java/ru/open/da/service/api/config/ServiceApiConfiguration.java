package ru.open.da.service.api.config;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.open.da.service.api.feign.ResourceClient;
import ru.open.da.service.api.service.ResourceAmqpApi;
import ru.open.da.service.api.service.ResourceRestApi;
import ru.open.da.service.api.service.impl.ResourceAmqpApiImpl;
import ru.open.da.service.api.service.impl.ResourceRestApiImpl;
import ru.open.da.service.contract.ResourceAmqpContract;
import ru.open.da.service.contract.ResourceRestContract;

import static ru.open.da.service.contract.ResourceAmqpContract.DEFAULT_RESOURCE_EXCHANGE_NAME;


@Configuration
@AutoConfigureAfter(FeignAutoConfiguration.class)
@EnableFeignClients(clients = ResourceClient.class)
@Import(ResourceAmqpContract.class)
@ConditionalOnProperty(prefix = "service-api", name = "enabled", matchIfMissing = true)
@RequiredArgsConstructor
public class ServiceApiConfiguration {

    @Bean
    public ResourceRestApi resourceRestApi(ResourceClient resourceClient) {
        return new ResourceRestApiImpl(resourceClient);
    }

    @Bean
    public ResourceAmqpApi resourceService(ConnectionFactory connectionFactory, MessageConverter resourceAmqpMessageConverter) {
        val rabbitTemplate = resourceRabbitTemplate(connectionFactory, resourceAmqpMessageConverter);
        return new ResourceAmqpApiImpl(rabbitTemplate);
    }

    private RabbitTemplate resourceRabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        val rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        rabbitTemplate.setExchange(DEFAULT_RESOURCE_EXCHANGE_NAME);
        return rabbitTemplate;
    }
}
