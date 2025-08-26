package org.jedi_bachelor.strategy.model.map;

import org.jedi_bachelor.strategy.model.buildings.Building;

import java.util.ArrayList;
import java.util.List;

public class MapTell {
    private final String nameOfProvince;

    private List<Building> buildingList;
    private final int x;
    private final int y;

    private int people;

    public MapTell(String name, int x, int y, int people) {
        this.buildingList = new ArrayList<>();

        this.x = x;
        this.y = y;

        this.nameOfProvince = name;

        this.people = people;
    }

    public void addBuilding(Building building) {
        this.buildingList.add(building);
    }

    public String getNameOfProvince() {
        return nameOfProvince;
    }

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<Building> buildingList) {
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
