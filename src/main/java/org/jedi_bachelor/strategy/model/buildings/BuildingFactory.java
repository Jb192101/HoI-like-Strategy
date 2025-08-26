package org.jedi_bachelor.strategy.model.buildings;

import org.jedi_bachelor.strategy.model.effects.Features;

import org.springframework.stereotype.Service;

@Service
public class BuildingFactory {
    private Features features;

    private final int timeToBuildFarm = 2;
    private final int timeToBuildCivilFactory = 10;
    private final int timeToBuildMilitaryFactory = 11;
    private final int timeToBuildOilRefineries = 7;

    private int budget;

    public Building createFarm() {
        return new Farm(this.budget);
    }

    public Building createCivilFactory(TypeOfConsumerGoods type) {
        return new CivilFactory(type, this.budget);
    }

    public Building createMilitaryFactory(TypeOfWeapon type) {
        return new MilitaryFactory(type, this.budget);
    }

    public Building createOilRefineries() {
        return new OilRefinerie(this.budget);
    }

    public void setBudget(int value) {
        this.budget = value;
    }
}
