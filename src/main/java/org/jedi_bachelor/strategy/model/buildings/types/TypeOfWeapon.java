package org.jedi_bachelor.strategy.model.buildings.types;

public enum TypeOfWeapon {
    INFANTRY_EQUIPMENT(25.0f, 30.0f),
    ARTILLERY(105.0f, 121.0f),
    ARMORED_VEHICLE(123.0f, 156.0f),
    TANK(250.0f, 320.0f);

    private final float costOfProduction;
    private final float costOfBuying;

    TypeOfWeapon(float cost, float cost2) {
        this.costOfProduction = cost;

        this.costOfBuying = cost2;
    }

    public float getCost() {
        return this.costOfProduction;
    }

    public float getCostOfBuying() {
        return this.costOfBuying;
    }
}
