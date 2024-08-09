package org.example;

import org.example.island.IslandLive;
import org.example.island.VegetationLive;
import org.example.service.ScheduledTaskService;

import org.springframework.scheduling.annotation.EnableScheduling;



public class RunWorld{
    public static void main(String[] args) throws InterruptedException {


        IslandLive islandLive = new IslandLive();
        islandLive.initialize();
        VegetationLive.getInstance().initializeVegetation();
        VegetationLive.getInstance().countInCageAll();
        VegetationLive.getInstance().countAll();
        while (!islandLive.isEndSimulation()) {
            try {
                islandLive.simulation();
                Thread.sleep(20);
                VegetationLive.getInstance().countInCageAll();
                VegetationLive.getInstance().countAll();
                VegetationLive.getInstance().vegetationReproduction();
                Thread.sleep(20);
                VegetationLive.getInstance().nextTurnVeg();
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
                System.out.println("==============");
                System.out.println("Конец симуляции.");
                System.out.println("==============");
}


}