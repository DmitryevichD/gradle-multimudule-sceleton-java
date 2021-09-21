package ru.open.da.service.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.open.da.service.api.ResourceRestApi;
import ru.open.da.service.api.impl.ResourceRestApiImpl;
import ru.open.da.service.feign.ResourceClient;

@Configuration
@AutoConfigureAfter(FeignAutoConfiguration.class)
@EnableFeignClients(clients = ResourceClient.class)
public class RestApiConfiguration {

    @Bean
    public ResourceRestApi resourceRestApi(ResourceClient resourceClient) {
        return new ResourceRestApiImpl(resourceClient);
    }
}
