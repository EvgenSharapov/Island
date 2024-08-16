package org.example.island;
import org.example.island.characters.VegetationCharacters;
import org.example.island.factory.FactoryVegetation;
import org.example.vegetation.Vegetation;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.example.island.characters.IslandCharacters.*;
public class VegetationLive {
    private static VegetationLive ourInstance = new VegetationLive();

    public static VegetationLive getInstance() {
        return ourInstance;
    }
    private VegetationLive() {}


    ArrayList<Vegetation>[][] vegetationPull =new ArrayList[WIDTH][HEIGHT];

    private Map<String, Integer>[][] countInCage = new HashMap[WIDTH][HEIGHT];

    private Map<String,Integer>countAll=new HashMap<>();
    private int countVegetation;



    public synchronized ArrayList<Vegetation>[][] getVegetationPull() {
        return vegetationPull;
    }
    public synchronized void setVegetationPull(ArrayList<Vegetation>[][] vegetationPull) {
        this.vegetationPull = vegetationPull;
    }

    public Map<String, Integer> getCountAll() {
        return countAll;
    }


    public void initializeVegetation() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                IslandCage islandCage=new IslandCage();
                vegetationPull[i][j]=islandCage.getRandVegetationInCageStart(START_POPULATION_VEGETATION);
            }
        }
        countInCageAll();
        countAll();
    }


    private   void countInCageAll() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {

                CopyOnWriteArrayList<Vegetation> vegetation =new CopyOnWriteArrayList<>(vegetationPull[i][j]);

                Map<String, Integer> vegTemp = new HashMap<>();
                for (String str : VegetationCharacters.getInstance().vegetationInCage.keySet()) {
                    countVegetation = 0;
                    try{
                    for (Vegetation veg : vegetation) {
                        if(veg==null){continue;}
                        if (veg.toString().equals(str)) {
                            countVegetation++;
                        }
                    }}catch (Exception e){
                        System.out.println("countInCageAll"+e);
                    }
                    vegTemp.put(str, countVegetation);
                }
                countInCage[i][j] = vegTemp;
            }
        }
    }
    private   void vegetationReproduction() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if(vegetationPull[i][j].isEmpty()){
                    IslandCage islandCage=new IslandCage();
                    vegetationPull[i][j]=islandCage.getRandVegetationInCageStart(POPULATION_VEGETATION_IN_EMPTY);
                }
                CopyOnWriteArrayList<Vegetation> vegetation =new CopyOnWriteArrayList<>(vegetationPull[i][j]);

                try{
                for (Vegetation veg : new ArrayList<>(vegetation)) {
                    if(veg==null){continue;}
                    if(countInCage[i][j].get(veg.toString())>=VegetationCharacters.getInstance().vegetationInCage.get(veg.toString())){continue;}
                    if(veg.reproduction()){
                        vegetationPull[i][j].add(FactoryVegetation.create(veg.toString()));}
                }}catch (NullPointerException e){
    System.out.println("vegetationReproduction"+e);
}
            }
        }
    }
    private void countAll() {
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
    private void nextTurnVeg(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                CopyOnWriteArrayList<Vegetation> vegetation =new CopyOnWriteArrayList<>(vegetationPull[i][j]);
                try{
                for (Vegetation veg : new ArrayList<>(vegetation)) {
                    if(veg==null){continue;}
                    veg.setReproduction(false);
                }}catch (NullPointerException e){
                    System.out.println("nextTurnVeg"+e);
                }
            }
        }

    }
    public void simulation(){
        countInCageAll();
        countAll();
        vegetationReproduction();
        nextTurnVeg();
    }
}