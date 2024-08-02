package org.example;

import org.example.island.IslandCage;
import org.example.island.IslandInit;

public class RunWorld {
    public static void main(String[] args) throws InterruptedException {
        IslandInit islandInit=new IslandInit();
        islandInit.initialize();
        islandInit.live();
        while (true){
            islandInit.moveAll();
            Thread.sleep(1100);
            islandInit.live();
            Thread.sleep(1100);
            islandInit.eatAll();
            Thread.sleep(1100);
            islandInit.allReproduction();
            Thread.sleep(1100);
            islandInit.allDeath();
            Thread.sleep(1100);
            islandInit.info();
            Thread.sleep(1100);
            islandInit.nextTurn();
            Thread.sleep(1100);
        }
    }

}