package org.jedi_bachelor.strategy.model.buildings;

public enum TypeOfConsumerGoods {
    MEDICAL(1.0f, 1.5f),
    WEATHER(1.5f, 2.5f),
    AUTO(100.0f, 143.0f),
    FURNITURE(15.0f, 32.3f),
    ALCOHOL(0.6f, 1.8f);

    private final float cost;
    private final float costOfBuying;

    TypeOfConsumerGoods(float cost, float cost2) {
        this.cost = cost;
        this.costOfBuying = cost2;
    }

    public float getCost() {
        return this.cost;
    }

    public float getCostOfBuying() {
        return this.costOfBuying;
    }
}
