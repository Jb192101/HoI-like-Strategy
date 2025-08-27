package org.jedi_bachelor.strategy.model.military;

public class TankDivision extends Division {
    public TankDivision(int x, int y, int countOfBrigades) {
        super(x, y, countOfBrigades);

        this.health = countOfBrigades*25;
        this.maxHealth = health;

        this.attackEffort = 105*countOfBrigades;
        this.defenceEffort = 5*countOfBrigades;
    }

    @Override
    public void takeDamage(int value) {
        super.takeDamage(value);
    }
}
