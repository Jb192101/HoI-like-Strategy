package org.jedi_bachelor.strategy.model.focuses;

import org.jedi_bachelor.strategy.model.effects.Features;

import java.util.List;

public class NationalFocusTree {
    private Features features;

    private List<NationalFocus> nationalFocuses;

    public NationalFocusTree(Features features) {
        this.features = features;
    }

    public void addFocus(NationalFocus focus) {
        this.nationalFocuses.add(focus);
    }
}
