package org.jedi_bachelor.strategy.economics;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GeneralEconomic {
    private Integer money;
}
