package org.jedi_bachelor.strategy.model.focuses;

import org.jedi_bachelor.strategy.model.effects.Features;
import org.jedi_bachelor.strategy.model.effects.FeaturesEnum;

public class NationalFocus {
    private int cost; // time of execution
    private int executedTime; // executedTime <= cost

    private NationalFocus[] nexts;

    private Features features;

    // For adding effect to state
    private FeaturesEnum feature;
    private float powerOfFeature;

    public NationalFocus(int cost) {
        setTime(cost);

        nexts = null;
    }

    public NationalFocus(int cost, NationalFocus focus1) {
        setTime(cost);

        nexts = new NationalFocus[1];
        nexts[0] = focus1;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    private void setTime(int cost) {
        this.cost = cost;
        executedTime = 0;
    }

    private void updateExecutedTime() {
        this.executedTime++;

        if(this.executedTime == this.cost) {
            this.execute();
        }
    }

    public void execute() {
        if(this.features != null) {
            switch (this.feature) {
                case FeaturesEnum.ATTACK_EFFORT -> this.features.addAttackEffort(this.powerOfFeature);
                case FeaturesEnum.DEFENCE_EFFORT -> this.features.addDefenceEffort(this.powerOfFeature);
                case FeaturesEnum.EFFECTIVITY_CIVIL_INDUSTRY ->
                        this.features.addEffectivityCivilIndustry(this.powerOfFeature);
                case FeaturesEnum.EFFECTIVITY_FARMS -> this.features.addEffectivityFarms(this.powerOfFeature);
                case FeaturesEnum.EFFECTIVITY_MILITARY_INDUSTRY ->
                        this.features.addEffectivityMilitaryIndustry(this.powerOfFeature);
                case FeaturesEnum.PROFITABILITY -> this.features.addProfitability(this.powerOfFeature);
                case FeaturesEnum.SPEED_BUILD ->
                        this.features.addSpeedOfBuilding(this.powerOfFeature);
            }
        }
    }
}
