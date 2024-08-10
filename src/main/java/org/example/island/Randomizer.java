package org.example.island;

import org.example.animals.Direction;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
        private static Randomizer ourInstance = new Randomizer();

        public static Randomizer getInstance() {
            return ourInstance;
        }
        private Randomizer() {
        }
        public int randomizer(int i){
            return ThreadLocalRandom.current().nextInt(0, i);
        }
    public Direction randomDirection(){
        Direction[]directions=Direction.values();
        int value = Randomizer.getInstance().randomizer(directions.length+1);
        switch (value){
            case 0:return Direction.UP;
            case 1:return Direction.DOWN;
            case 2:return Direction.RIGHT;
            default:return Direction.LEFT;
        }
    }
}
