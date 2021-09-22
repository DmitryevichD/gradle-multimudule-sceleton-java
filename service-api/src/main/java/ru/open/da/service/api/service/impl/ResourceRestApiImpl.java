package ru.open.da.service.api.service.impl;

import lombok.RequiredArgsConstructor;
import ru.open.da.service.api.service.ResourceRestApi;
import ru.open.da.service.api.feign.ResourceClient;
import ru.open.da.service.contract.model.dto.ResourceDto;

import java.util.UUID;

@RequiredArgsConstructor
public class ResourceRestApiImpl implements ResourceRestApi {
    private final ResourceClient resourceClient;
    @Override
    public ResourceDto getRandomResource() {
        return resourceClient.getResource(UUID.randomUUID());
    }
}
