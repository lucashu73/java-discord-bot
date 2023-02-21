package me.lucashu;

import java.util.List;

// Represents a champion having a name, cost (tier), and 1 to 3 classes/origins/traits (WIP)
public class Champion {
    private String name;
    private int cost;
    private List<String> traits;

    // REQUIRES: name, cost, and non-empty traits of champion
    // EFFECTS: name is set to initialName
    //          cost is set to initialCost
    //          traits is set to initialTraits
    public Champion(String initialName, int initialCost, List<String> initialTraits)  {
        this.name = initialName;
        this.cost = initialCost;
        this.traits = initialTraits;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public List<String> getTraits() {
        return traits;
    }


}
