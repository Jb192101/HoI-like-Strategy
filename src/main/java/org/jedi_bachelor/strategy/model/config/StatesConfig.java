package org.jedi_bachelor.strategy.model.config;

import org.jedi_bachelor.strategy.DoingInterface;
import org.jedi_bachelor.strategy.model.buildings.TypeOfConsumerGoods;
import org.jedi_bachelor.strategy.model.buildings.TypeOfWeapon;
import org.jedi_bachelor.strategy.model.effects.FeaturesEnum;
import org.jedi_bachelor.strategy.model.map.MapTell;
import org.jedi_bachelor.strategy.model.politics.Leader;
import org.jedi_bachelor.strategy.model.politics.State;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/* || Format of building state ||
    1. Initialize state
    2. Add money
    3. Set leader
    4. Set national focus tree
    5. Add territory
    6. Set politic parties
*/

@Configuration
@ComponentScan("org.jedi_bachelor.strategy")
public class StatesConfig {
    @Bean
    public DoingInterface doingInterface() {
        return new DoingInterface();
    }

    @Bean
    public State germanyState() {
        State state = new State("German Empire");

        state.addMoney(5000);
        state.setLeader(new Leader("Wilhelm II", FeaturesEnum.ATTACK_EFFORT, 0.1f));

        // Add territory
        List<MapTell> territory = new ArrayList<>();
        territory.add(new MapTell("Berlin", 1, 1, 100_000));
        territory.add(new MapTell("Bavaria", 1, 2, 250_000));

        state.getBuildingFactory().setBudget(100_000);
        territory.get(1).addBuilding(state.getBuildingFactory().createCivilFactory(TypeOfConsumerGoods.WEATHER));
        territory.get(1).addBuilding(state.getBuildingFactory().createMilitaryFactory(TypeOfWeapon.INFANTRY_EQUIPMENT));

        state.setTerritory(territory);

        return state;
    }
}
