package org.example;

import org.example.island.IslandCage;
import org.example.island.IslandInit;
import org.example.island.VegetationLive;

public class RunWorld {
    public static void main(String[] args) throws InterruptedException {
        IslandInit islandInit=new IslandInit();
        islandInit.initialize();
        VegetationLive.getInstance().initializeVegetation();
        islandInit.live();
        VegetationLive.getInstance().countInCageAll();
        while (true){
            islandInit.moveAll();
            Thread.sleep(20);
            islandInit.live();
            Thread.sleep(20);



            VegetationLive.getInstance().countInCageAll();
            Thread.sleep(20);
            VegetationLive.getInstance().countAll();
            Thread.sleep(20);

            islandInit.eatAll();
            Thread.sleep(20);
            islandInit.allReproduction();
            Thread.sleep(20);

            VegetationLive.getInstance().vegetationReproduction();

            Thread.sleep(20);
            islandInit.allDeath();
            Thread.sleep(20);

            islandInit.info();
            Thread.sleep(20);
            islandInit.nextTurn();
            Thread.sleep(20);
            VegetationLive.getInstance().nextTurnVeg();
            Thread.sleep(20);
        }
    }

}