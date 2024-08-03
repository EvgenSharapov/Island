package org.example.island;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
        private static Randomizer ourInstance = new Randomizer();

        public static Randomizer getInstance() {
            return ourInstance;
        }
        private Randomizer() {
        }
        public int randomizer(int i){
            int value = ThreadLocalRandom.current().nextInt(0, i);
            return value;
        }
}
