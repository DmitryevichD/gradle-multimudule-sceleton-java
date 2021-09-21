package ru.open.da.service.api.impl;

import lombok.RequiredArgsConstructor;
import ru.open.da.service.api.ResourceRestApi;
import ru.open.da.service.feign.ResourceClient;
import ru.open.da.services.model.ResourceDto;

import java.util.UUID;

@RequiredArgsConstructor
public class ResourceRestApiImpl implements ResourceRestApi {
    private final ResourceClient resourceClient;
    @Override
    public ResourceDto getRandomResource() {
        return resourceClient.getResource(UUID.randomUUID());
    }
}
