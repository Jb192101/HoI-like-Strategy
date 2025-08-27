package org.jedi_bachelor.strategy.model.map;

import org.jedi_bachelor.strategy.model.buildings.Building;
import org.jedi_bachelor.strategy.model.buildings.ConstructionTask;
import org.jedi_bachelor.strategy.model.politics.State;

import java.util.LinkedList;
import java.util.List;

public class MapTell {
    private final String nameOfProvince;
    private final TerrainType type;

    private State controllerOfState;

    private Building[] buildingList;
    private final int x;
    private final int y;

    private int people;

    private List<ConstructionTask> taskQueue;

    public MapTell(String name, TerrainType type,
                   int x, int y, int people,
                   int capacity, State state) {
        this.type = type;
        this.buildingList = new Building[capacity];

        this.x = x;
        this.y = y;

        this.nameOfProvince = name;

        this.people = people;

        this.controllerOfState = state;
        this.taskQueue = new LinkedList<>();
    }

    public void addTask(ConstructionTask task) {
        this.taskQueue.add(task);
    }

    public synchronized void process() {
        if(this.taskQueue.isEmpty()) {
            return;
        } else {
            if(this.controllerOfState.getMoney() >= this.taskQueue.getFirst().getBuildingForConstruction().getMoneyToBuilding() &&
                    this.controllerOfState.getMachines() >= this.taskQueue.getFirst().getBuildingForConstruction().getNeededCountOfMachines()) {
                this.controllerOfState.addMoney(-1 * this.taskQueue.getFirst().getBuildingForConstruction().getMoneyToBuilding());
                this.controllerOfState.addMachines(-1 * this.taskQueue.getFirst().getBuildingForConstruction().getNeededCountOfMachines());
                this.taskQueue.getFirst().process();
                // After this task most be deleted
                this.addBuilding(this.taskQueue.removeFirst().getBuildingForConstruction());
            }
        }
    }

    private void addBuilding(Building building) {
        for(int i = 0; i < buildingList.length; i++) {
            if(buildingList[i] == null) {
                buildingList[i] = building;
            }
        }
    }

    public String getNameOfProvince() {
        return nameOfProvince;
    }

    public Building[] getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(Building[] buildingList) {
        this.buildingList = buildingList;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPeople() {
        return people;
    }
}
