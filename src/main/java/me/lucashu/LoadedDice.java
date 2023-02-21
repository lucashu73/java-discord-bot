package me.lucashu;

import java.util.Arrays;

// Loaded dice calculator (WIP)
public class LoadedDice {

    private ListOfChampion myList;

    public LoadedDice() {
        setup();
    }

    public void setup() {
        myList = new ListOfChampion();

        myList.addChampion(new Champion("Ashe", 1, Arrays.asList("Laser Corps", "Recon")));
    }

    // given name of champion and player level calculate loaded dice odds
    public ListOfChampion odds(String name, int level) {
        Champion champion = myList.getChampion(name);

        ListOfChampion possibleChamps = myList.getSublistContaining(champion);

        return null;


    }

}
