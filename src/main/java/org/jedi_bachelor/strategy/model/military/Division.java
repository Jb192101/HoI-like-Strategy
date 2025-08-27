package org.jedi_bachelor.strategy.model.military;

abstract public class Division {
    protected int countOfBrigades;

    protected int health;
    protected int maxHealth;

    protected int x;
    protected int y;

    protected float attackEffort;
    protected float defenceEffort;

    protected boolean isCombatCapacity = true;

    public Division(int x, int y, int countOfBrigades) {
        this.x = x;
        this.y = y;

        this.countOfBrigades = countOfBrigades;
    }

    // this method must be called in all move
    public void recovery() {
        if(this.health < this.maxHealth) {
            addHealth(1);
        }
    }

    public void takeDamage(int value) {
        this.health -= value;
        if(this.health < 0) {
            this.health = 0;
            this.isCombatCapacity = false;
            return;
        }
    }

    public void addHealth(int value) {
        this.health += value;
        if(this.health > 0 && !isCombatCapacity) {
            this.isCombatCapacity = true;
        }


    }

    public void move(Direction dir) {
        switch(dir) {
            case Direction.UP -> {
                if(true) { // in future change it
                    y++;
                }
            }
            case Direction.DOWN -> {
                if(true) { // in future change it
                    y--;
                }
            }
            case Direction.LEFT -> {
                if(true) { // in future change it
                    x--;
                }
            }
            case Direction.RIGHT -> {
                if(true) { // in future change it
                    x++;
                }
            }
        }
    }


}
