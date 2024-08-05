package org.example.island;

import org.example.animals.Animal;
import org.example.island.characters.AnimalCharacters;
import org.example.island.characters.VegetationCharacters;
import org.example.island.factory.FactoryVegetation;
import org.example.vegetation.Vegetation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.island.characters.IslandCharacters.*;


public class VegetationLive {
    FactoryVegetation factoryVegetation = new FactoryVegetation();

    private ArrayList<Vegetation>[][] vegetationPull = new ArrayList[WIDTH][HEIGHT];

    public ArrayList<Vegetation>[][] getVegetationPull() {
        return vegetationPull;
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
                IslandCage islandCage=new IslandCage(i,j);
                vegetationPull[i][j]=islandCage.getRandVegetationInCage();
            }
        }


    }


    public void countInCageAll() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {

                ArrayList<Vegetation> vegetation = vegetationPull[i][j];
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




    public void vegetationReproduction() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Vegetation> vegetation = vegetationPull[i][j];
                    for (Vegetation veg : new ArrayList<>(vegetation)) {
                       if(countInCage[i][j].get(veg.toString())>=VegetationCharacters.getInstance().vegetationInCage.get(veg.toString())){continue;}
                        if(veg.reproduction()){
                                vegetationPull[i][j].add(factoryVegetation.create(veg.toString()));}
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
                        if (veg.toString().equals(str)) {
                            count+=countInCage[i][j].get(veg);
                        }
                    }
                }
            }
           System.out.println(str+": "+count);
            this.countAll.put(str, count);
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
