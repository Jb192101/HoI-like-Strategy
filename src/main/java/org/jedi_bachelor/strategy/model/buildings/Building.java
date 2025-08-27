package org.jedi_bachelor.strategy.model.buildings;

import org.jedi_bachelor.strategy.model.effects.Features;

abstract public class Building implements IProductionalBuilding {
    protected int production;
    protected Features features;
    protected boolean isProductional; // can building product or not

    protected int abilityToProductValue;

    protected int budget;

    // Health
    protected int maxHealth;
    protected int currentHealth;

    // Construction pay
    protected int moneyToBuilding;
    protected int timeToBuilding;
    protected int neededCountOfMachines;

    public int getProduction() {
        return production;
    }

    // In case if province was change a controller
    public void setFeatures(Features features) {
        this.features = features;
    }

    @Override
    public void product() {
        if(this.currentHealth < 0.5 * maxHealth) {
            this.isProductional = false;
            return;
        } else {
            this.isProductional = true;
        }
    }

    public void subsiding(int value) {
        this.budget += value;
    }

    public int getMoneyToBuilding() {
        return moneyToBuilding;
    }

    public int getTimeToBuilding() {
        return timeToBuilding;
    }

    public int getNeededCountOfMachines() {
        return neededCountOfMachines;
    }
}
