package org.jedi_bachelor.strategy;

import org.jedi_bachelor.strategy.model.buildings.*;
import org.jedi_bachelor.strategy.model.map.MapTell;
import org.jedi_bachelor.strategy.model.politics.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class DoingInterface {
    private Scanner scan = new Scanner(System.in);
    @Autowired
    @Qualifier("germanyState")
    private State stateOfPlayer;

    public void go() {
        int act;
        System.out.println();
        while(true) {
            printInfoAboutState();
            printActs();
            act = scan.nextInt();
            switch(act) {
                case 1:
                    printFactories();
                case 100:
                    skipDay();
            }
            System.out.println();
        }
    }

    public void printInfoAboutState() {
        System.out.println("||==================||");
        System.out.println(stateOfPlayer.getNameOfState());
        System.out.println(stateOfPlayer.getLeader());
        System.out.println("Budget: " + stateOfPlayer.getMoney());
        System.out.println("Taxes: " + stateOfPlayer.getTaxOnCivils() * 100 + "%");
        System.out.println("People: " + stateOfPlayer.getPeople());
        System.out.println("||==================||");
    }

    public void printActs() {
        System.out.println("ACTS");
        System.out.println("||==================||");
        System.out.println("1. Watch factories");
        System.out.println("100. Skip day");
    }

    public void printFactories() {
        List<MapTell> list = stateOfPlayer.getTerritory();
        for(MapTell tell : list) {
            System.out.println(tell.getBuildingList());
        }

        int act;
        System.out.println("ACTS");
        System.out.println("1. Subsiding");
        act = scan.nextInt();

        switch(act) {
            case 1:
                subsiding(list);
        }
    }

    private void subsiding(List<MapTell> list) {
        int act, money;
        System.out.println("Take a number of building in list");
        act = scan.nextInt();
        System.out.println("Take a money");
        money = scan.nextInt();
        stateOfPlayer.addMoney(-1*money);
        list.get(act).getBuildingList()[act].subsiding(money);
    }

    private void skipDay() {
        stateOfPlayer.addDay();
        if(stateOfPlayer.getTimerOfTakingTaxes() % 2 == 0) {
            stateOfPlayer.takeTaxes();
        }

        for(MapTell tell : stateOfPlayer.getTerritory()) {
            for(Building building : tell.getBuildingList()) {
                if(building instanceof MilitaryFactory) {
                    ((MilitaryFactory) building).product();
                } else if(building instanceof  CivilFactory) {
                    ((CivilFactory) building).product();
                } else if(building instanceof Farm) {
                    ((Farm) building).product();
                } else if(building instanceof OilRefinerie) {
                    ((OilRefinerie) building).product();
                }
            }
        }

    }
}
