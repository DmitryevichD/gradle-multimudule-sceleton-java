package ru.open.da.service.api.service;

import ru.open.da.service.contract.model.message.ResourceMessage;

public interface ResourceAmqpApi {
    void sendMessage(ResourceMessage resourceMessage);
}
