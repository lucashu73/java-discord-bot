package me.lucashu;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

// Represents a list of champions (WIP)
public class ListOfChampion {

    private LinkedList<Champion> loc;

    // EFFECTS: constructs an empty list of champions
    public ListOfChampion() {
        loc = new LinkedList<>();
    }

    // MODIFIES: this
    // EFFECTS: add champion to end of queue
    public void addChampion(Champion champion) {
        loc.addLast(champion);
    }

    // EFFECTS: gets champion with given name
    public Champion getChampion(String name) {
        Champion champion = null;

        for (Champion c : this.loc) {
            if (Objects.equals(name, c.getName())) {
                champion = c;
            }
        }

        return champion;
    }

    // EFFECTS: get sublist of champions with same traits as given champion
    public ListOfChampion getSublistContaining(Champion champion) {
        ListOfChampion tempList = new ListOfChampion();

        for (String t: champion.getTraits()) {
            for (Champion c : this.loc) {
                if (c.getTraits().contains(t)) {
                    tempList.addChampion(c);
                }
            }
        }

        return tempList;
    }

    // EFFECTS: returns the number of champion in the catalogue
    public int length() {
        return loc.size();
    }

    // EFFECTS: returns an unmodifiable list of champions
    public List<Champion> getListOfChampion() {
        return Collections.unmodifiableList(loc);
    }

}
