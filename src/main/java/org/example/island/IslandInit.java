package org.example.island;
import org.example.animals.Animal;
import org.example.animals.Direction;
import org.example.island.characters.AnimalCharacters;

import java.util.ArrayList;

import static org.example.island.characters.AnimalCharacters.HEIGHT;
import static org.example.island.characters.AnimalCharacters.WIDTH;

public class IslandInit {
    public ArrayList<Animal>[][] island = new ArrayList[AnimalCharacters.getInstance().HEIGHT][AnimalCharacters.getInstance().WIDTH];
    private int countAnimalInCage;
    private int countAllAnimals;
    private int countDeath;
    FactoryAnimals factory=new FactoryAnimals();



    public void initialize() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                IslandCage islandCage=new IslandCage(i,j);
                island[i][j]=islandCage.getRandAnimalsInCage();
            }
        }
    }
    public void live(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal>animals=island[i][j];
                System.out.println("Клетка-"+i+"-"+j);
        for(String str:AnimalCharacters.getInstance().animalsCage.keySet()){
            countAnimalInCage=0;
            for(Animal animal:animals){
                if(animal.toString().equals(str)){
                    countAnimalInCage++;
                }
            }
            System.out.println(str+"-"+countAnimalInCage);
        }
            }
        }
    }
    public Direction randomDirection(){
        Direction[]directions=Direction.values();
        int value = Randomizer.getInstance().randomizer(directions.length);
            switch (value){
                case 0:return Direction.UP;
                case 1:return Direction.DOWN;
                case 2:return Direction.RIGHT;
                default:return Direction.LEFT;
            }
    }
    public void moveAll(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                for (Animal animal : new ArrayList<>(animals)) {
                    int speed =Randomizer.getInstance().randomizer(AnimalCharacters.getInstance().animalsSpeed.get(animal.toString()));
                    Direction direction=randomDirection();
                    while ((direction==Direction.UP&&j==0)||(direction==Direction.DOWN&&j==HEIGHT-1)||
                            (direction==Direction.LEFT&&i==0)||(direction==Direction.RIGHT&&j==WIDTH-1)){
                        direction= randomDirection();
                    }
                    if (direction == Direction.UP) {
                        if (j - speed < 0) {
                            island[i][0].add(animal);
                            island[i][j].remove(animal);
                        } else {
                            island[i][j - speed].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (direction == Direction.DOWN) {
                        if (j + speed > HEIGHT - 1) {
                            island[i][HEIGHT - 1].add(animal);
                            island[i][j].remove(animal);
                        } else {
                            island[i][j + speed].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (direction == Direction.LEFT) {
                        if (i - speed < 0) {
                            island[0][j].add(animal);
                            island[i][j].remove(animal);
                        } else {
                            island[i - speed][j].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (direction == Direction.RIGHT) {
                        if (i + speed > WIDTH - 1) {
                            island[WIDTH - 1][j].add(animal);
                            island[i][j].remove(animal);
                        } else {
                            island[i + speed][j].add(animal);
                            island[i][j].remove(animal);
                        }
                    }
                }
            }
        }
    }
    public void info(){
        for(String str:AnimalCharacters.getInstance().animalsCage.keySet()){
            countAllAnimals=0;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal>animals=island[i][j];
                    for(Animal animal:animals){
                        if(animal.toString().equals(str)){
                            countAllAnimals++;
                        }
                    }
                }
            }
            System.out.println(str+"-"+countAllAnimals);
        }
    }
    public void eatAll(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                Animal[]animal= island[i][j].toArray(new Animal[island[i][j].size()]);
                for(int x=0;x<animal.length;x++){
                    for (Animal anim : new ArrayList<>(animals)) {
                        if (animal[x].eat(anim)) {
                            if(anim.getWeight()>animal[x].getMaxEat()){
                            animal[x].setWeight(animal[x].getWeight()+animal[x].getMaxEat());}
                            else{animal[x].setWeight(animal[x].getWeight()+anim.getWeight());}
                            island[i][j].remove(anim);
                            animal[x].setEat(true);break;
                        }
                        else {animal[x].setEat(true);break;}
                    }
                }
            }
        }
    }
    public void allReproduction(){

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Animal[]animal= island[i][j].toArray(new Animal[island[i][j].size()]);
                ArrayList<Animal> animals = island[i][j];
                for(int x=0;x<animal.length;x++){
                    for (Animal anim : new ArrayList<>(animals)) {
                        if((animal[x].getAge()>3)&& (!animal[x].isReproduction()&&!anim.isReproduction())){
                            animal[x].setReproduction(true);anim.setReproduction(true);
                            if(Randomizer.getInstance().randomizer(9)<AnimalCharacters.getInstance().CHANCE_REPRODUCTION){
                            island[i][j].add(factory.create(anim.toString()));}
                        }
                    }
                }
            }
        }

    }

    public void nextTurn() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                for (Animal anim : new ArrayList<>(animals)) {
                    anim.setWeight(anim.getWeight()*0.9);
                    anim.setEat(false);
                    anim.setReproduction(false);
                    anim.setAge(anim.getAge()+1);
                    if(anim.toString().equals("Rabbit")){anim.setWeight(anim.getWeight()+0.4);}
                    if(anim.toString().equals("Duck")){anim.setWeight(anim.getWeight()+0.5);}
                    if(anim.toString().equals("Horse")){anim.setWeight(anim.getWeight()+15);}
                    if(anim.toString().equals("Deer")){anim.setWeight(anim.getWeight()+13);}
                    if(anim.toString().equals("Mouse")){anim.setWeight(anim.getWeight()+0.02);}
                    if(anim.toString().equals("Goat")){anim.setWeight(anim.getWeight()+5);}
                    if(anim.toString().equals("Sheep")){anim.setWeight(anim.getWeight()+5);}
                    if(anim.toString().equals("WildBoar")){anim.setWeight(anim.getWeight()+50);}
                    if(anim.toString().equals("Buffalo")){anim.setWeight(anim.getWeight()+100);}

                }
            }
        }
    }
    public void allDeath() {
        countDeath=0;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                for (Animal anim : new ArrayList<>(animals)) {
                if((anim.getWeight()*100<AnimalCharacters.getInstance().animalsWeight.get(anim.toString())*55)||anim.getAge()>10){
                    island[i][j].remove(anim);
                    countDeath++;
                }
                }
            }
        }
        System.out.println("Умерло от голода: "+countDeath);
    }

}
