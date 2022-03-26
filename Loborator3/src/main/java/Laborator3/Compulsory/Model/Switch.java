package laborator3.compulsory.model;
/**
 * Created by Alexoaie Adrian Sebastian
 * This class extends the node class, contains the constructors and toString method
 */

public class Switch extends Node{
    private int orderNumber;

    public Switch() {
        this.orderNumber = super.counter;
    }

    public Switch(String hardwareAddress, String locationOnTheMap, String name) {
        super(hardwareAddress, locationOnTheMap, name);
        this.orderNumber = super.counter;
    }

    @Override
    public String toString() {
        return "V" + this.orderNumber + " (Switch " + super.getName() + ") ";
    }
}
