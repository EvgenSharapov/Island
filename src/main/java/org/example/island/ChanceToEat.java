package org.example.island;

import org.example.animals.Animal;
import static org.example.island.characters.AnimalCharacters.*;

public class ChanceToEat {
    private Animal eater;
    private Animal eat;


    public int chanceEat(Animal eater,Animal eat){
        if(eater.toString().equals(WOLF_NAME)) {
            switch (eat.toString()){
                case RABBIT_NAME:
                case GOAT_NAME:return 60;
                case DUCK_NAME:return 40;
                case HORSE_NAME:
                case BUFFALO_NAME:return 10;
                case DEER_NAME:
                case WILD_BOAR_NAME:return 15;
                case MOUSE_NAME:return 80;
                case SHEEP_NAME:return 70;
            }
        }
        if(eater.toString().equals(FOX_NAME)) {
            switch (eat.toString()) {
                case RABBIT_NAME:
                    return 70;
                case DUCK_NAME:
                    return 60;
                case MOUSE_NAME:
                    return 90;
            }
        }
        if(eater.toString().equals(BOA_NAME)){
            switch (eat.toString()){
                case RABBIT_NAME:return 20;
                case DUCK_NAME:return 10;
                case MOUSE_NAME:return 40;
            }
        }
        if(eater.toString().equals(EAGLE_NAME)){
            switch (eat.toString()){
                case FOX_NAME:return 10;
                case RABBIT_NAME:
                case MOUSE_NAME:return 90;
                case DUCK_NAME:return 80;
            }
        }
        if(eater.toString().equals(BEAR_NAME)) {
            switch (eat.toString()) {
                case BOA_NAME:
                case RABBIT_NAME:
                case DEER_NAME:
                    return 80;
                case HORSE_NAME:
                    return 40;
                case DUCK_NAME:
                    return 10;
                case MOUSE_NAME:
                    return 90;
                case SHEEP_NAME:
                case GOAT_NAME:
                    return 70;
                case WILD_BOAR_NAME:
                    return 50;
                case BUFFALO_NAME:
                    return 20;
            }
        }
        return 0;
    }

}
