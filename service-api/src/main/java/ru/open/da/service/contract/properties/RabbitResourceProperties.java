package ru.open.da.service.contract.properties;

import lombok.Data;

@Data
public class RabbitResourceProperties {
    private static final String DEFAULT_RESOURCE_EXCHANGE_NAME = "service.resources";
    private static final String DEFAULT_RESOURCE_QUEUE_NAME = "service.resources.queue";
    private static final String DEFAULT_RESOURCE_ROUTING_KEY = "resourceKey";

    private String exchangeName = DEFAULT_RESOURCE_EXCHANGE_NAME;
    private UserParamListener userParamListener = new UserParamListener();

    @Data
    public static class UserParamListener {
        private String queueName = DEFAULT_RESOURCE_QUEUE_NAME;
        private String routeKey = DEFAULT_RESOURCE_ROUTING_KEY;
    }
}
