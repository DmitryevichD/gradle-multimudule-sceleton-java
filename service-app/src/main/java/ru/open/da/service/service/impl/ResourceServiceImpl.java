package ru.open.da.service.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.open.da.service.service.ResourceService;
import ru.open.da.service.contract.model.dto.ResourceDto;
import ru.open.da.service.contract.model.message.ResourceMessage;

import java.util.UUID;

@Slf4j
@Service
public class ResourceServiceImpl implements ResourceService {
    @Override
    public ResourceDto getResource(UUID ruleId) {
        log.info("Receive request by rest. Request uuid: {}", ruleId);
        return new ResourceDto(ruleId, UUID.randomUUID().toString());
    }

    @RabbitListener(queues = "#{resourceQueue}")
    @Override
    public void messageHandler(ResourceMessage resourceMessage) {
        log.info("Receive message. Id: {}, name: {}", resourceMessage.getResourceId(), resourceMessage.getResourceName());
    }
}
