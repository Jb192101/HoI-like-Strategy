package org.jedi_bachelor.strategy.model.config;

import org.jedi_bachelor.strategy.model.map.MapTell;
import org.jedi_bachelor.strategy.model.map.TerrainType;

import org.jedi_bachelor.strategy.model.politics.State;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Configuration file for maptells

@Configuration
@ComponentScan("org.jedi_bachelor.strategy.model.map")
public class TerritoryConfig {
    private ConfigurableApplicationContext springContext =
            new AnnotationConfigApplicationContext(StatesConfig.class);

    // German territories
    @Bean
    public MapTell berlinTell() {
        return new MapTell("Berlin", TerrainType.PLAINS,
                1, 1, 150_000, 10,
                springContext.getBean("germanState", State.class));
    }

    // French territories

}
