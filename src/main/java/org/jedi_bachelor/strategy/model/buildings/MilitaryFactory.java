package org.jedi_bachelor.strategy.model.buildings;

// It's state non-commercial organization, but it require a money to product

public class MilitaryFactory extends Building {
    private final TypeOfWeapon type;

    public MilitaryFactory(TypeOfWeapon type, int budget) {
        this.type = type;
        this.budget = budget;

        this.abilityToProductValue = 350;

        this.currentHealth = 250;
        this.maxHealth = 250;
    }

    @Override
    public void product() {
        super.product();

        if(this.budget < this.abilityToProductValue * this.currentHealth) {
            System.out.println(this.budget);
            System.out.println(this.abilityToProductValue * this.currentHealth);
            return;
        }

        this.production += (int) (((this.abilityToProductValue * this.currentHealth) / this.type.getCost()) * this.features.getEffectivityMilitaryIndustry());
        this.budget -= (int) (this.abilityToProductValue * this.currentHealth
                * this.features.getEffectivityMilitaryIndustry());
    }

    // Subsidies
    public void addBudget(int value) {
        this.budget += value;
    }

    @Override
    public String toString() {
        return "MilitaryFactory{" +
                "type=" + type +
                ", production=" + production +
                ", isProductional=" + isProductional +
                ", budget=" + budget +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                '}';
    }
}
