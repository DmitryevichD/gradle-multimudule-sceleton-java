package ru.open.da.service.api.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import ru.open.da.service.api.ResourceAmqpApi;
import ru.open.da.services.model.message.ResourceMessage;

import static ru.open.da.services.contract.ResourceAmqpContract.DEFAULT_RESOURCE_EXCHANGE_NAME;

@RequiredArgsConstructor
public class ResourceAmqpApiImpl implements ResourceAmqpApi {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(ResourceMessage resourceMessage) {
        rabbitTemplate.convertAndSend(DEFAULT_RESOURCE_EXCHANGE_NAME, resourceMessage);
    }
}
