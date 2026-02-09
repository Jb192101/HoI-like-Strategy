package org.jedi_bachelor.strategy.economics.enums;

import lombok.Getter;

@Getter
public enum ResourceEnum {
    STEEL(
            9
    ),

    WOOD(
            4
    ),

    SKIN(
            2
    ),

    GRAIN_CULTURE(
            1
    ),

    MEAT_FOOD(
            4
    ),

    COPPER(
            7
    );

    private int cost;

    ResourceEnum(int cost) {
        this.cost = cost;
    }
}
