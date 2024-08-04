package org.example.island;

import org.example.animals.Animal;
import org.example.island.characters.AnimalCharacters;

public class ChanceToEat {
    private Animal eater;
    private Animal eat;


    public int chanceEat(Animal eater,Animal eat){
        if(eater.toString().equals(AnimalCharacters.getInstance().WOLF_NAME)) {
                if (eat.toString().equals(AnimalCharacters.getInstance().RABBIT_NAME)) {return 60;}
                if (eat.toString().equals(AnimalCharacters.getInstance().DUCK_NAME)) {return 40;}
                if (eat.toString().equals(AnimalCharacters.getInstance().HORSE_NAME)) {return 10;}
                if (eat.toString().equals(AnimalCharacters.getInstance().DEER_NAME)) {return 15;}
                if (eat.toString().equals(AnimalCharacters.getInstance().MOUSE_NAME)) {return 80;}
                if (eat.toString().equals(AnimalCharacters.getInstance().GOAT_NAME)) {return 60;}
                if (eat.toString().equals(AnimalCharacters.getInstance().SHEEP_NAME)) {return 70;}
                if (eat.toString().equals(AnimalCharacters.getInstance().WILD_BOAR_NAME)) {return 15;}
                if (eat.toString().equals(AnimalCharacters.getInstance().BUFFALO_NAME)) {return 10;}




        }

        if(eater.toString().equals(AnimalCharacters.getInstance().FOX_NAME)){
            if(eat.toString().equals(AnimalCharacters.getInstance().RABBIT_NAME)){return 70;}
            if(eat.toString().equals(AnimalCharacters.getInstance().DUCK_NAME)){return 60;}
            if (eat.toString().equals(AnimalCharacters.getInstance().MOUSE_NAME)) {return 90;}



        }

        if(eater.toString().equals(AnimalCharacters.getInstance().BOA_NAME)){
            if(eat.toString().equals(AnimalCharacters.getInstance().FOX_NAME)){return 15;}
            if(eat.toString().equals(AnimalCharacters.getInstance().RABBIT_NAME)){return 20;}
            if(eat.toString().equals(AnimalCharacters.getInstance().DUCK_NAME)){return 10;}
            if (eat.toString().equals(AnimalCharacters.getInstance().MOUSE_NAME)) {return 40;}





        }

        if(eater.toString().equals(AnimalCharacters.getInstance().EAGLE_NAME)){
            if(eat.toString().equals(AnimalCharacters.getInstance().FOX_NAME)){return 10;}
            if(eat.toString().equals(AnimalCharacters.getInstance().RABBIT_NAME)){return 90;}
            if(eat.toString().equals(AnimalCharacters.getInstance().DUCK_NAME)){return 80;}
            if (eat.toString().equals(AnimalCharacters.getInstance().MOUSE_NAME)) {return 90;}


        }




        if(eater.toString().equals(AnimalCharacters.getInstance().BEAR_NAME)){
            if(eat.toString().equals(AnimalCharacters.getInstance().BOA_NAME)){return 80;}
            if(eat.toString().equals(AnimalCharacters.getInstance().HORSE_NAME)){return 40;}
            if(eat.toString().equals(AnimalCharacters.getInstance().RABBIT_NAME)){return 80;}
            if(eat.toString().equals(AnimalCharacters.getInstance().DUCK_NAME)){return 10;}
            if(eat.toString().equals(AnimalCharacters.getInstance().DEER_NAME)){return 80;}
            if (eat.toString().equals(AnimalCharacters.getInstance().MOUSE_NAME)) {return 90;}
            if (eat.toString().equals(AnimalCharacters.getInstance().GOAT_NAME)) {return 70;}
            if (eat.toString().equals(AnimalCharacters.getInstance().SHEEP_NAME)) {return 70;}
            if (eat.toString().equals(AnimalCharacters.getInstance().WILD_BOAR_NAME)) {return 50;}
            if (eat.toString().equals(AnimalCharacters.getInstance().BUFFALO_NAME)) {return 20;}
            }









        else{return 0;}
        return 0;
    }

}
