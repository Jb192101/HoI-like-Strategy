package org.jedi_bachelor.strategy.model.military;

public class InfantryDivision extends Division {
    public InfantryDivision(int x, int y, int countOfBrigades) {
        super(x, y, countOfBrigades);

        this.health = countOfBrigades*10;
        this.maxHealth = health;

        this.attackEffort = 15*countOfBrigades;
        this.defenceEffort = 90*countOfBrigades;
    }

    @Override
    public void takeDamage(int value) {
        super.takeDamage(value);

        this.attackEffort -= 15*value;
        this.defenceEffort -= 90*value;
    }
}
