package org.jedi_bachelor.strategy.politics;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class State {
    private String name;
    private String nameOfLeader;
}
