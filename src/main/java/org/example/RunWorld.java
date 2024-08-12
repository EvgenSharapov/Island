package org.example;

import org.example.island.IslandLive;
import org.example.island.VegetationLive;
import org.example.service.ScheduledTaskService;

import org.springframework.scheduling.annotation.EnableScheduling;



public class RunWorld implements Runnable {
    String name;
    Thread thread;
    boolean isRunning=false;

    public RunWorld(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("Новый поток :" + thread);
    }

    public static void main(String[] args) {
        RunWorld runWorld1 = new RunWorld("runWorld1");
        runWorld1.thread.start();
        System.out.println("Поток r1 работает:" + runWorld1.thread.isAlive());

    }


    @Override
    public void run() {
        IslandLive islandLive = new IslandLive();
        islandLive.initialize();
        VegetationLive.getInstance().initializeVegetation();
        VegetationLive.getInstance().countInCageAll();
        VegetationLive.getInstance().countAll();
        try {
            while (!islandLive.isEndSimulation()) {
                try {
                    islandLive.simulation();
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
    catch(Exception e){
        throw new RuntimeException(e);
    }

    }
}
