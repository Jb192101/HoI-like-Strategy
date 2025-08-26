package org.jedi_bachelor.strategy.model.buildings;

public enum Oil {
    OIL(50.0f, 78.0f);

    private final float costOfMaining;
    private final float costOfBuying;

    Oil(float cost1, float cost2) {
        this.costOfMaining = cost1;
        this.costOfBuying = cost2;
    }

    public float getCostOfBuying() {
        return this.costOfBuying;
    }

    public float getCostOfMaining() {
        return this.costOfMaining;
    }
}
