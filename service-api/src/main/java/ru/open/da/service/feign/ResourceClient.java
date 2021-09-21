package ru.open.da.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import ru.open.da.services.contract.ResourceRestContract;

@FeignClient(
        name = "resourceService",
        url = "${service.api.rest.url:}"
)
public interface ResourceClient extends ResourceRestContract {
}
