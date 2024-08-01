package org.example;

import org.example.island.IslandCage;
import org.example.island.IslandInit;

public class RunWorld {
    public static void main(String[] args) {
        IslandInit islandInit=new IslandInit();
        islandInit.initialize();
        islandInit.live();

    }
}