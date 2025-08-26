package org.jedi_bachelor.strategy.model.effects;

public class Features {
    // Economics / industry / finances
    private float effectivityCivilIndustry;
    private float effectivityMilitaryIndustry;
    private float effectivityFarms;
    private float effectivityOilRefineries;
    private float profitability;

    // Military
    private float attackEffort;
    private float defenceEffort;

    // Building
    private float speedOfBuilding;

    public Features() {
        this.effectivityCivilIndustry = 0.5f;
        this.effectivityMilitaryIndustry = 0.3f;
        this.effectivityFarms = 0.45f;
        this.effectivityOilRefineries = 0.6f;
        this.profitability = 1.0f;

        this.attackEffort = 0.1f;
        this.defenceEffort = 0.3f;

        this.speedOfBuilding = 1.0f;
    }

    public void addAttackEffort(float value) {
        this.attackEffort += value;
    }

    public void addDefenceEffort(float value) {
        this.defenceEffort += value;
    }

    public void addSpeedOfBuilding(float value) {
        this.speedOfBuilding += value;
    }

    public void addProfitability(float value) {
        this.profitability += value;
    }

    public void addEffectivityCivilIndustry(float value) {
        this.effectivityCivilIndustry += value;
    }

    public void addEffectivityMilitaryIndustry(float value) {
        this.effectivityMilitaryIndustry += value;
    }

    public void addEffectivityFarms(float value) {
        this.effectivityFarms += value;
    }

    public void addEffectivityOilRefineries(float value) {
        this.effectivityOilRefineries += value;
    }

    // Getters
    public float getEffectivityCivilIndustry() {
        return effectivityCivilIndustry;
    }

    public float getEffectivityMilitaryIndustry() {
        return effectivityMilitaryIndustry;
    }

    public float getEffectivityFarms() {
        return effectivityFarms;
    }

    public float getProfitability() {
        return profitability;
    }

    public float getAttackEffort() {
        return attackEffort;
    }

    public float getDefenceEffort() {
        return defenceEffort;
    }

    public float getSpeedOfBuilding() {
        return speedOfBuilding;
    }

    public float getEffectivityOilRefineries() {
        return effectivityOilRefineries;
    }
}
