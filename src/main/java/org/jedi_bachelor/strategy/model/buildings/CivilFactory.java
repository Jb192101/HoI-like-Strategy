package org.jedi_bachelor.strategy.model.buildings;

public class CivilFactory extends Building implements ITradingOfProduction {
    private final TypeOfConsumerGoods type;

    public CivilFactory(TypeOfConsumerGoods type, int budget) {
        this.type = type;
        this.budget = budget;

        this.abilityToProductValue = 250;

        this.currentHealth = 250;
        this.maxHealth = 250;
    }

    // Struct:
    //      1. Adding production
    //      2. Removing budget (cost of production)
    @Override
    public void product() {
        super.product();

        if(this.budget <= this.abilityToProductValue * this.currentHealth) {
            return;
        }

        this.production += (int) ((this.abilityToProductValue * this.currentHealth / this.type.getCost())
                * this.features.getEffectivityCivilIndustry());
        this.budget -= (int) (this.abilityToProductValue * this.currentHealth
                * this.features.getEffectivityCivilIndustry());
    }

    @Override
    public int tradeProduction(int value) {
        if(this.production >= value) {
            this.production -= value;
            this.budget += (int) (value * this.type.getCostOfBuying());
        } else {
            return 0;
        }

        return value;
    }

    @Override
    public String toString() {
        return "CivilFactory{" +
                "isProductional=" + isProductional +
                ", production=" + production +
                ", budget=" + budget +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                '}';
    }
}
