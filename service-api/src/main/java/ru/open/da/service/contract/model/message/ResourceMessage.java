package ru.open.da.service.contract.model.message;

import lombok.Data;

import java.util.UUID;

@Data
public class ResourceMessage {
    private UUID resourceId;
    private String resourceName;
}
