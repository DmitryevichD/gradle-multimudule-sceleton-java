package ru.open.da.services.contract;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.open.da.services.model.ResourceDto;

import java.util.UUID;

public interface ResourceRestContract {
    @Operation(summary = "Метод возвращает рандомный ресурс")
    @RequestMapping(method = RequestMethod.GET, path = "/api/service/v1/resources/{resourceId}")
    ResourceDto getResource(@PathVariable("resourceId") UUID ruleId);
}
