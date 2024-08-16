package org.example.island;
import org.example.island.characters.VegetationCharacters;
import org.example.island.factory.FactoryVegetation;
import org.example.vegetation.Vegetation;


import java.util.*;

import static org.example.island.characters.IslandCharacters.*;
public class VegetationLive {
    private static VegetationLive ourInstance = new VegetationLive();

    public static VegetationLive getInstance() {
        return ourInstance;
    }
    private VegetationLive() {
    }
     ArrayList<Vegetation>[][] vegetationPull = new ArrayList[WIDTH][HEIGHT];

    public synchronized ArrayList<Vegetation>[][] getVegetationPull() {
        return vegetationPull;
    }
    public synchronized void setVegetationPull(ArrayList<Vegetation>[][] vegetationPull) {
        this.vegetationPull = vegetationPull;
    }

    private Map<String, Integer>[][] countInCage = new HashMap[WIDTH][HEIGHT];

    public Map<String, Integer> getCountAll() {
        return countAll;
    }

    private Map<String,Integer>countAll=new HashMap<>();
    private int countVegetation;



    public void initializeVegetation() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                IslandCage islandCage=new IslandCage();
                vegetationPull[i][j]=islandCage.getRandVegetationInCageStart();
            }
        }
    }


    public synchronized void countInCageAll() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {

                List<Vegetation> vegetation =Collections.synchronizedList(vegetationPull[i][j]);

                Map<String, Integer> vegTemp = new HashMap<>();
                for (String str : VegetationCharacters.getInstance().vegetationInCage.keySet()) {
                    countVegetation = 0;
                    for (Vegetation veg : vegetation) {
                        if (veg.toString().equals(str)) {
                            countVegetation++;
                        }
                    }
                    vegTemp.put(str, countVegetation);
                }
                countInCage[i][j] = vegTemp;
            }
        }
    }
    public synchronized void vegetationReproduction() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Vegetation> vegetation = vegetationPull[i][j];
                    for (Vegetation veg : new ArrayList<>(vegetation)) {
                       if(countInCage[i][j].get(veg.toString())>=VegetationCharacters.getInstance().vegetationInCage.get(veg.toString())){continue;}
                        if(veg.reproduction()){
                                vegetationPull[i][j].add(FactoryVegetation.create(veg.toString()));}
                        }
                    }
                }
            }
    public void countAll() {
        for (String str : VegetationCharacters.getInstance().vegetationInCage.keySet()) {
            int count = 0;
            for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT; j++) {
                    for (String veg : countInCage[i][j].keySet()) {
                        if (veg.equals(str)) {
                            count+=countInCage[i][j].get(veg);
                        }
                    }
                }
            }
            countAll.put(str, count);
        }
    }
    public void nextTurnVeg(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Vegetation> vegetation = vegetationPull[i][j];
                for (Vegetation veg : new ArrayList<>(vegetation)) {
                    veg.setReproduction(false);
                }
            }
        }

    }
}
