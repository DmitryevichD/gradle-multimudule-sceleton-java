package ru.open.da.services.model.message;

import lombok.Data;

import java.util.UUID;

@Data
public class ResourceMessage {
    private UUID resourceId;
    private String resourceName;
}
