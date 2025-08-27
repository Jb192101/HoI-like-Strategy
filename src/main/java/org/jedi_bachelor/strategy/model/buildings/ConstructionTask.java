package org.jedi_bachelor.strategy.model.buildings;

public class ConstructionTask {
    private Building buildingForConstruction;

    public ConstructionTask(Building b, int budget, int count) {
        this.buildingForConstruction = b;
    }

    public synchronized void process() {
        // Starting a new thread
        for(int i = 0; i < buildingForConstruction.getTimeToBuilding(); i++) {
            // Задержка в ходе
        }
    }

    public Building getBuildingForConstruction() {
        return buildingForConstruction;
    }
}
