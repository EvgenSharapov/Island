package org.example;

import org.example.island.IslandLive;
import org.example.island.VegetationLive;


public class RunWorld implements Runnable {
    String name;
    Thread thread;
    static boolean isRunning=true;

    public RunWorld(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("Новый поток :" + thread);
    }

    public static void main(String[] args) throws InterruptedException {
        RunWorld runWorld = new RunWorld("runWorld");
        runWorld.thread.start();
        System.out.println("Поток r1 работает:" + runWorld.thread.isAlive());
        while (isRunning){
            Thread.sleep(700);
            VegetationLive.getInstance().simulation();
        }


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
                    islandLive.simulation();
                    //VegetationLive.getInstance().nextTurnVeg();
                    Thread.sleep(700);
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