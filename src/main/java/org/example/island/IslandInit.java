package org.example.island;
import org.example.animals.Animal;
import org.example.animals.Direction;

import java.util.ArrayList;
import java.util.Random;

import static org.example.island.AnimalCharacters.HEIGHT;
import static org.example.island.AnimalCharacters.WIDTH;

public class IslandInit {
    AnimalCharacters animalCharacters=new AnimalCharacters();
    public int x;
    public int y;

    public ArrayList<Animal>[][] island = new ArrayList[animalCharacters.HEIGHT][animalCharacters.WIDTH];
    private int countAnimalInCage;



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
        for(String str:animalCharacters.animalsCage.keySet()){
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
        Random r=new Random();
        int random= r.nextInt(directions.length-1);
            switch (random){
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
                    int speed = animalCharacters.animalsSpeed.get(animal.toString());

                    if (randomDirection() == Direction.UP) {
                        if (j - speed < 0) {
                            island[i][0].add(animal);
                            island[i][j].remove(animal);
                        } else {
                            island[i][j - speed].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (randomDirection() == Direction.DOWN) {
                        if (j + speed > HEIGHT - 1) {
                            island[i][HEIGHT - 1].add(animal);
                            island[i][j].remove(animal);
                        } else {
                            island[i][j + speed].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (randomDirection() == Direction.LEFT) {
                        if (i - speed < 0) {
                            island[0][j].add(animal);
                            island[i][j].remove(animal);
                        } else {
                            island[i - speed][j].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (randomDirection() == Direction.RIGHT) {
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
}
