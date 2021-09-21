package ru.open.da.services.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ResourceDto {
    private UUID id;
    private String name;
}
