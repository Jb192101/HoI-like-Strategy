package org.jedi_bachelor.strategy.model.politics;

import org.jedi_bachelor.strategy.model.buildings.Building;
import org.jedi_bachelor.strategy.model.effects.Features;
import org.jedi_bachelor.strategy.model.effects.FeaturesEnum;
import org.jedi_bachelor.strategy.model.focuses.NationalFocusTree;
import org.jedi_bachelor.strategy.model.map.MapTell;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class State {
    private final String nameOfState;

    // Finances
    private int money;

    // Material products
    private Materials materials;

    // Taxes
    private float taxOnCivils = 0.1f; // money += taxOnCivils * manpower
    private int timerOfTakingTaxes = 0; // need to update after all day

    private Leader leader;

    private Features features;

    private NationalFocusTree nationalFocusTree;

    // Map
    private List<MapTell> territory;

    public State(String name) {
        this.nameOfState = name;

        this.features = new Features();
    }

    public void setLeader(Leader leader) {
        this.leader = leader;

        if(this.leader != null) {
            switch (this.leader.getFeature()) {
                case FeaturesEnum.ATTACK_EFFORT -> this.features.addAttackEffort(this.leader.getPowerOfFeature());
                case FeaturesEnum.DEFENCE_EFFORT -> this.features.addDefenceEffort(this.leader.getPowerOfFeature());
                case FeaturesEnum.EFFECTIVITY_CIVIL_INDUSTRY ->
                        this.features.addEffectivityCivilIndustry(this.leader.getPowerOfFeature());
                case FeaturesEnum.EFFECTIVITY_FARMS ->
                        this.features.addEffectivityFarms(this.leader.getPowerOfFeature());
                case FeaturesEnum.EFFECTIVITY_MILITARY_INDUSTRY ->
                        this.features.addEffectivityMilitaryIndustry(this.leader.getPowerOfFeature());
                case FeaturesEnum.PROFITABILITY -> this.features.addProfitability(this.leader.getPowerOfFeature());
                case FeaturesEnum.SPEED_BUILD ->
                    this.features.addSpeedOfBuilding(this.leader.getPowerOfFeature());
            }
        }
    }

    public void setTerritory(List<MapTell> territory) {
        this.territory = territory;
        for(MapTell tell : territory) {
            for (Building b : tell.getBuildingList()) {
                if(b != null)
                    b.setFeatures(this.features);
            }
        }
    }

    public void addMoney(int value) {
        this.money += value;
    }

    public void takeTaxes() {
        addMoney((int) (getPeople() * this.taxOnCivils));
    }

    public String getNameOfState() {
        return nameOfState;
    }

    public Leader getLeader() {
        return leader;
    }

    public int getMoney() {
        return money;
    }

    public float getTaxOnCivils() {
        return taxOnCivils;
    }

    public int getPeople() {
        int people = 0;
        for(MapTell tell : territory) {
            people += tell.getPeople();
        }

        return people;
    }

    public List<MapTell> getTerritory() {
        return territory;
    }

    public void addDay() {
        this.timerOfTakingTaxes++;
    }

    public int getTimerOfTakingTaxes() {
        return timerOfTakingTaxes;
    }

    // Materials
    public int getMachines() {
        return this.materials.getMachines();
    }

    public void addMachines(int value) {
        this.materials.addMachines(value);
    }
}