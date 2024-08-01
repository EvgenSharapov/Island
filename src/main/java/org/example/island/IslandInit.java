package org.example.island;
import org.example.animals.Animal;
import java.util.ArrayList;
import static org.example.island.AnimalCharacters.HEIGHT;
import static org.example.island.AnimalCharacters.WIDTH;

public class IslandInit {
    AnimalCharacters animalCharacters=new AnimalCharacters();

    public ArrayList<Animal>[][] island = new ArrayList[animalCharacters.HEIGHT][animalCharacters.WIDTH];
    private int countAnimalInCage;


    public void initialize() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                IslandCage islandCage=new IslandCage(i,j);
                island[i][j]=islandCage.getRandAnimalsInCage();
            }
        }
        for(int x=0;x<animalCharacters.HEIGHT;x++){
            for(int y=0;y<animalCharacters.WIDTH;y++){
                for(Animal animal:island[x][y]){
                }
            }
        }
    }
    public void live(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal>animals=island[i][j];
                System.out.println("Клетка-"+i+"-"+j);
        for(String str:animalCharacters.animals.keySet()){
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
    public void moveAll(){

    }




}
