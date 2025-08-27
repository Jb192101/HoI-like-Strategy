package org.jedi_bachelor.strategy.model.buildings;

// It's private commercial organization

import org.jedi_bachelor.strategy.model.buildings.types.Oil;

public class OilRefinerie extends Building implements ITradingOfProduction {
    private final Oil oil;

    public OilRefinerie(int budget) {
        this.oil = Oil.OIL;
        this.budget = budget;

        this.abilityToProductValue = 1000;

        this.currentHealth = 100;
        this.maxHealth = 100;

        this.moneyToBuilding = 10000;
        this.neededCountOfMachines = 150;
        this.timeToBuilding = 5;
    }

    @Override
    public void product() {
        super.product();

        if(this.budget < this.abilityToProductValue * this.currentHealth) {
            return;
        }

        this.production += (int) (this.abilityToProductValue
                * this.currentHealth / this.oil.getCostOfMaining()
                * this.features.getEffectivityOilRefineries()); // adding fuel
        this.budget -= (int) (this.abilityToProductValue * this.currentHealth
                * this.features.getEffectivityOilRefineries());
    }

    @Override
    public int tradeProduction(int value) {
        if(this.production >= value) {
            this.production -= value;
            this.budget += (int) (value * this.oil.getCostOfBuying());
        } else {
            return 0;
        }

        return value;
    }
}
