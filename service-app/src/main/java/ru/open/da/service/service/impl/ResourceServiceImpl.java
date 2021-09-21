package ru.open.da.service.service.impl;

import org.springframework.stereotype.Service;
import ru.open.da.service.service.ResourceService;
import ru.open.da.services.model.ResourceDto;

import java.util.UUID;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Override
    public ResourceDto getResource(UUID ruleId) {
        return new ResourceDto(ruleId, UUID.randomUUID().toString());
    }
}
