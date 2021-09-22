package ru.open.da.service.api.feign;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cloud.openfeign.FeignClient;
import ru.open.da.service.api.config.ServiceApiConfiguration;
import ru.open.da.service.contract.ResourceRestContract;

//@ConditionalOnBean(ServiceApiConfiguration.class)
@FeignClient(
        name = "resourceService",
        url = "${service.api.rest.url:}"
)
public interface ResourceClient extends ResourceRestContract {
}
