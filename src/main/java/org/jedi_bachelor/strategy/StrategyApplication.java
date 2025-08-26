package org.jedi_bachelor.strategy;

import org.jedi_bachelor.strategy.model.config.StatesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class StrategyApplication {
	private static ConfigurableApplicationContext springContext;

	public static void main(String[] args) {
		SpringApplication.run(StrategyApplication.class, args);

		springContext = new AnnotationConfigApplicationContext(StatesConfig.class);
		DoingInterface doingInterface = springContext.getBean("doingInterface", DoingInterface.class);
		doingInterface.go();
	}

}
