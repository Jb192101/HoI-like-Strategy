package org.jedi_bachelor.strategy.model.buildings;

public class Farm extends Building implements ITradingOfProduction {
    public Farm(int budget) {
        this.budget = budget;

        this.abilityToProductValue = 1000;

        this.currentHealth = 250;
        this.maxHealth = 250;
    }

    @Override
    public void product() {
        super.product();

        if(this.budget <= this.abilityToProductValue * this.currentHealth) {
            return;
        }

        this.production += (int) ((this.abilityToProductValue
                * this.currentHealth / 500) * this.features.getEffectivityFarms());
        this.budget -= (int) (this.features.getEffectivityFarms() * this.currentHealth
                * this.features.getEffectivityFarms());
    }

    @Override
    public int tradeProduction(int value) {
        if(this.production >= value) {
            this.production -= value;
            this.budget += (int) (value * 1000);
        } else {
            return 0;
        }

        return value;
    }
}
