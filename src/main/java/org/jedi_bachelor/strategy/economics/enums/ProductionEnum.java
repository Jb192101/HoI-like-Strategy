package org.jedi_bachelor.strategy.economics.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum ProductionEnum {
    // Одежда
    CLOTHES(
            (Map<ResourceEnum, Byte>) new HashMap<>().put(ResourceEnum.SKIN, Byte.valueOf((byte) 5))
    ),

    // Доспехи
    ARMOR(
            (Map<ResourceEnum, Byte>) new HashMap<>().put(ResourceEnum.STEEL, Byte.valueOf((byte) 15))
    ),

    // Меч
    SWORD(
            (Map<ResourceEnum, Byte>) new HashMap<>().put(ResourceEnum.STEEL, Byte.valueOf((byte) 4))
    ),

    // Копьё
    SPEAR(
            (Map<ResourceEnum, Byte>) new HashMap<>().put(ResourceEnum.STEEL, Byte.valueOf((byte) 3))
    );

    private Map<ResourceEnum, Byte> resources;

    ProductionEnum(Map<ResourceEnum, Byte> resources) {
        this.resources = resources;
    }

    public byte getResourceCount(ResourceEnum resource) {
        return this.resources.get(resource);
    }
}
