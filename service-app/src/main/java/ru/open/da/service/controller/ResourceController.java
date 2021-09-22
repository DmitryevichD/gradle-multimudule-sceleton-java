package ru.open.da.service.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.open.da.service.service.ResourceService;
import ru.open.da.service.contract.ResourceRestContract;
import ru.open.da.service.contract.model.dto.ResourceDto;

import java.util.UUID;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Resource", description = "Публичный API для получения ресурса")
@RequiredArgsConstructor
// Swagger -> http://localhost:8080/swagger-ui.html
// API - http://localhost:8080/api/service/v1/resources/0ae7402f-d032-4c56-bdd0-2377849414c9
public class ResourceController implements ResourceRestContract {
    private final ResourceService resourceService;

    @Override
    public ResourceDto getResource(UUID ruleId) {
        return resourceService.getResource(ruleId);
    }
}
