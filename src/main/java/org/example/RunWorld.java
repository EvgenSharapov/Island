package org.example;

import org.example.island.IslandLive;
import org.example.island.VegetationLive;


public class RunWorld{

    static boolean isRunning=true;

    public static void main(String[] args) {
        Thread thread1=new Thread(() -> {
            IslandLive islandLive = new IslandLive();
            islandLive.initialize();
            VegetationLive.getInstance().initializeVegetation();
            VegetationLive.getInstance().countInCageAll();
            VegetationLive.getInstance().countAll();
            try {
                while (!islandLive.isEndSimulation()) {
                    islandLive.simulation();
                    Thread.sleep(700);
                }

                System.out.println("==============");
                System.out.println("Конец симуляции.");
                System.out.println("==============");
                System.out.println("Загублено невинных душ за время симуляции: "+islandLive.getAnimalCounterForSimulation());
                System.out.println("Съедено растений за время симуляции: "+islandLive.getVegetationCounterForSimulation());
                isRunning=false;

            }
            catch(Exception e){
                throw new RuntimeException(e);
            }

    });
        thread1.start();
        System.out.println("Нить 1 работает: "+thread1.isAlive());

        Thread thread2=new Thread(() -> {
            while (isRunning){
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                VegetationLive.getInstance().simulation();
            }
        });
        thread2.start();
        System.out.println("Нить 2 работает: "+thread2.isAlive());

    }

}