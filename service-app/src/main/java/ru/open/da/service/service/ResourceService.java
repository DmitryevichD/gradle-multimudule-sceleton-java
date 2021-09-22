package ru.open.da.service.service;

import ru.open.da.services.model.dto.ResourceDto;
import ru.open.da.services.model.message.ResourceMessage;

import java.util.UUID;

public interface ResourceService {
    ResourceDto getResource(UUID ruleId);

    void messageHandler(ResourceMessage resourceMessage);
}
