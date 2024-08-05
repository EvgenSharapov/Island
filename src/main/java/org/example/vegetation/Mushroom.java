package org.example.vegetation;

public class Mushroom extends Vegetation{
    public Mushroom(double weight, boolean isReproduction) {
        super(weight, isReproduction);
    }
    @Override
    public String toString() {
        return "Mushroom";}
}
