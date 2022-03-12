package Laborator3.Compulsory.Model;
/**
 * Created by Alexoaie Adrian Sebastian
 * This class extends the node class, contains the constructors and toString method
 */

public class Switch extends Node{

    public Switch() {
        this.counter ++;
    }

    public Switch(String hardwareAddress, String locationOnTheMap, String name) {
        super(hardwareAddress, locationOnTheMap, name);
    }

    @Override
    public String toString() {
        return "V" + super.counter + " (Switch " + super.getName() + ") ";
    }
}
