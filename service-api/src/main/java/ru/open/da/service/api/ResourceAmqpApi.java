package ru.open.da.service.api;

import ru.open.da.services.model.message.ResourceMessage;

public interface ResourceAmqpApi {
    void sendMessage(ResourceMessage resourceMessage);
}
