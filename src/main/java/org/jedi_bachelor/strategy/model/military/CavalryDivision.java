package org.jedi_bachelor.strategy.model.military;

public class CavalryDivision extends Division {
    public CavalryDivision(int x, int y, int countOfBrigades) {
        super(x, y, countOfBrigades);

        this.health = countOfBrigades*15;
        this.maxHealth = health;

        this.attackEffort = 45*countOfBrigades;
        this.defenceEffort = 30*countOfBrigades;
    }

    @Override
    public void takeDamage(int value) {
        super.takeDamage(value);
    }
}
