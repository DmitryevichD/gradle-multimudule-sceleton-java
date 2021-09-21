package ru.open.da.service.service;

import ru.open.da.services.model.ResourceDto;

import java.util.UUID;

public interface ResourceService {
    ResourceDto getResource(UUID ruleId);
}
