package org.example;

import org.example.island.IslandLive;
import org.example.island.VegetationLive;


public class RunWorld implements Runnable {
    String name;
    Thread thread;
    static boolean isRunning=false;

    public RunWorld(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("Новый поток :" + thread);
    }

    public static void main(String[] args) throws InterruptedException {
        IslandLive islandLive = new IslandLive();
        RunWorld runWorld1 = new RunWorld("runWorld1");
        runWorld1.thread.start();
        System.out.println("Поток r1 работает:" + runWorld1.thread.isAlive());
        while (isRunning){
            Thread.sleep(700);
            VegetationLive.getInstance().vegetationReproduction();
            VegetationLive.getInstance().countInCageAll();
            VegetationLive.getInstance().countAll();
        }


    }


    @Override
    public void run() {
        isRunning=true;
        IslandLive islandLive = new IslandLive();
        islandLive.initialize();
        VegetationLive.getInstance().initializeVegetation();
        VegetationLive.getInstance().countInCageAll();
        VegetationLive.getInstance().countAll();
        try {
            while (!islandLive.isEndSimulation()) {
                    islandLive.simulation();
                    VegetationLive.getInstance().nextTurnVeg();
                    Thread.sleep(1000);
            }

            System.out.println("==============");
            System.out.println("Конец симуляции.");
            System.out.println("==============");
            thread.interrupt();
            isRunning=false;

        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

    }
}