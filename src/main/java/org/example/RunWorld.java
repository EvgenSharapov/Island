package org.example;

import org.example.island.IslandCage;
import org.example.island.IslandInit;
import org.example.island.VegetationLive;

public class RunWorld {
    public static void main(String[] args) throws InterruptedException {
        IslandInit islandInit=new IslandInit();
        VegetationLive vegetationLive=new VegetationLive();
        islandInit.initialize();
        vegetationLive.createVegetation();
        islandInit.live();
        while (true){
            islandInit.moveAll();
            Thread.sleep(20);
            islandInit.live();
            Thread.sleep(20);
            islandInit.eatAll();
            Thread.sleep(20);
            islandInit.allReproduction();
            Thread.sleep(20);
            islandInit.allDeath();
            Thread.sleep(20);
            islandInit.info();
            Thread.sleep(20);
            vegetationLive.vegetationReproduction();
            Thread.sleep(20);
            islandInit.nextTurn();
            Thread.sleep(20);
        }
    }

}