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
            Thread.sleep(2000);
            islandInit.live();
            Thread.sleep(2000);
        }
    }

}