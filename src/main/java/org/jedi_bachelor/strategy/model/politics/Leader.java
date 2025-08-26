package org.jedi_bachelor.strategy.model.politics;

import org.jedi_bachelor.strategy.model.effects.FeaturesEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Leader {
    private final String nameOfLeader;
    // trait
    private FeaturesEnum feature;
    private float powerOfFeature;

    public Leader(String name, FeaturesEnum feature, float powerOfFeature) {
        this.nameOfLeader = name;
        this.feature = feature;
        this.powerOfFeature = powerOfFeature;
    }

    public float getPowerOfFeature() {
        return powerOfFeature;
    }

    public FeaturesEnum getFeature() {
        return feature;
    }

    // FOR TESTS!!!

    @Override
    public String toString() {
        return "=====\n" + nameOfLeader + "\n" + feature + "\n" + powerOfFeature + "\n=====";
    }
}
