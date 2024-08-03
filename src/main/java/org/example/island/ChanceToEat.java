package org.example.island;

import org.example.animals.Animal;
import org.example.island.characters.AnimalCharacters;

public class ChanceToEat {
    AnimalCharacters animalCharacters;
    private Animal eater;
    private Animal eat;


    public int chanceEat(Animal eater,Animal eat){
        if(eater.toString().equals(animalCharacters.WOLF_NAME)){
            if(eat.toString().equals(animalCharacters.RABBIT_NAME)){return 80;}
        }
        if(eater.toString().equals(animalCharacters.FOX_NAME)){
            if(eat.toString().equals(animalCharacters.RABBIT_NAME)){return 80;}
        }
        if(eater.toString().equals(animalCharacters.BOA_NAME)){
            if(eat.toString().equals(animalCharacters.RABBIT_NAME)){return 80;}
        }
        if(eater.toString().equals(animalCharacters.EAGLE_NAME)){
            if(eat.toString().equals(animalCharacters.RABBIT_NAME)){return 80;}
        }

        if(eater.toString().equals(animalCharacters.WOLF_NAME)){
            if(eat.toString().equals(animalCharacters.DUCK_NAME)){return 80;}
        }
        if(eater.toString().equals(animalCharacters.FOX_NAME)){
            if(eat.toString().equals(animalCharacters.DUCK_NAME)){return 80;}
        }
        if(eater.toString().equals(animalCharacters.BOA_NAME)){
            if(eat.toString().equals(animalCharacters.DUCK_NAME)){return 80;}
        }
        if(eater.toString().equals(animalCharacters.EAGLE_NAME)){
            if(eat.toString().equals(animalCharacters.DUCK_NAME)){return 80;}
        }

        if(eater.toString().equals(animalCharacters.BEAR_NAME)){
            if(eat.toString().equals(animalCharacters.DUCK_NAME)){return 80;}
        }
        if(eater.toString().equals(animalCharacters.BEAR_NAME)){
            if(eat.toString().equals(animalCharacters.DUCK_NAME)){return 80;}
        }
        if(eater.toString().equals(animalCharacters.BEAR_NAME)){
            if(eat.toString().equals(animalCharacters.DUCK_NAME)){return 80;}
        }
        if(eater.toString().equals(animalCharacters.BEAR_NAME)){
            if(eat.toString().equals(animalCharacters.DUCK_NAME)){return 80;}
        }
        if(eater.toString().equals(animalCharacters.BEAR_NAME)){
            if(eat.toString().equals(animalCharacters.BOA_NAME)){return 50;}
        }





        else{return 0;}
        return 0;
    }

}
