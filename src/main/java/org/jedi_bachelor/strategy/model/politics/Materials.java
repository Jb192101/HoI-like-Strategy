package org.jedi_bachelor.strategy.model.politics;

// Class for saving a product of state

public class Materials {
    private int fuel;
    private int medicalEquipment;
    private int autos;
    private int weather;
    private int alcohol;
    private int furniture;
    private int machines;

    private int infantryEquipment;
    private int tanks;
    private int armoredVehicles;

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getMedicalEquipment() {
        return medicalEquipment;
    }

    public void setMedicalEquipment(int medicalEquipment) {
        this.medicalEquipment = medicalEquipment;
    }

    public int getAutos() {
        return autos;
    }

    public void setAutos(int autos) {
        this.autos = autos;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    public int getFurniture() {
        return furniture;
    }

    public void setFurniture(int furniture) {
        this.furniture = furniture;
    }

    public int getMachines() {
        return machines;
    }

    public void addMachines(int value) {
        this.machines += value;
    }

    public void setMachines(int machines) {
        this.machines = machines;
    }

    public int getInfantryEquipment() {
        return infantryEquipment;
    }

    public void setInfantryEquipment(int infantryEquipment) {
        this.infantryEquipment = infantryEquipment;
    }

    public int getTanks() {
        return tanks;
    }

    public void setTanks(int tanks) {
        this.tanks = tanks;
    }

    public int getArmoredVehicles() {
        return armoredVehicles;
    }

    public void setArmoredVehicles(int armoredVehicles) {
        this.armoredVehicles = armoredVehicles;
    }
}