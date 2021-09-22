package ru.open.da.service.service;

import ru.open.da.service.contract.model.dto.ResourceDto;
import ru.open.da.service.contract.model.message.ResourceMessage;

import java.util.UUID;

public interface ResourceService {
    ResourceDto getResource(UUID ruleId);

    void messageHandler(ResourceMessage resourceMessage);
}
