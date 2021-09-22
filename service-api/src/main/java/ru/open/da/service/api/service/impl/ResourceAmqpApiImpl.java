package ru.open.da.service.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import ru.open.da.service.api.service.ResourceAmqpApi;
import ru.open.da.service.contract.model.message.ResourceMessage;

import static ru.open.da.service.contract.ResourceAmqpContract.DEFAULT_RESOURCE_EXCHANGE_NAME;
import static ru.open.da.service.contract.ResourceAmqpContract.DEFAULT_RESOURCE_ROUTING_KEY;

@RequiredArgsConstructor
public class ResourceAmqpApiImpl implements ResourceAmqpApi {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(ResourceMessage resourceMessage) {
        rabbitTemplate.convertAndSend(DEFAULT_RESOURCE_ROUTING_KEY, resourceMessage);
    }
}
