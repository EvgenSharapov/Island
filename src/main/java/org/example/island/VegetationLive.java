package org.example.island;

import org.example.island.characters.VegetationCharacters;
import org.example.island.factory.FactoryVegetation;
import org.example.vegetation.Vegetation;

import java.util.ArrayList;
import java.util.List;
import static org.example.island.characters.IslandCharacters.*;


public class VegetationLive {
    FactoryVegetation factoryVegetation=new FactoryVegetation();
    private List<Vegetation>vegetationPull=new ArrayList<>();
    private int countVegetation;


    public void createVegetation(){
        countVegetation=0;
        for(String vegetation: VegetationCharacters.getInstance().vegetationInCage.keySet()){
         for(int i=0;i<HEIGHT;i++){
             for(int j=0;j<WIDTH;j++){
                 for(int c=0;c<Randomizer.getInstance().randomizer(VegetationCharacters.getInstance().vegetationInCage.get(vegetation));c++){
                     vegetationPull.add(factoryVegetation.create(vegetation,i,j));
                     countVegetation++;
                 }
             }
         }
            System.out.println(vegetation+": "+countVegetation);
        }
    }
    public void vegetationReproduction(){



        for(Vegetation vegetation:vegetationPull){
            if(vegetation.isReproduction()){vegetationPull.add(vegetation);}
        }
    }

}
