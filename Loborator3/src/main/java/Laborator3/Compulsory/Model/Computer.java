package laborator3.compulsory.model;

import laborator3.compulsory.interfaces.Identifiable;
import laborator3.compulsory.interfaces.Storage;

/**
 * Created by Alexoaie Adrian Sebastian
 * The computer class extends the Node class and implements the Identifiable class and the Storage class because
 * the class has to return an ip Address and The storage capacity
 * The class has two constructors, setters and getters and overrides the toString method
 */

public class Computer extends Node implements Identifiable, Storage {
    private String ipAddress;
    private double storageCapacity;
    private int orderNumber;

    public Computer(String hardwareAddress, String locationOnTheMap, String name, String ipAddress, double storageCapacity) {
        super(hardwareAddress, locationOnTheMap, name);
        this.ipAddress = ipAddress;
        this.storageCapacity = storageCapacity;
        this.orderNumber = super.counter;
    }

    public Computer() {
        this.orderNumber = super.counter;
    }

    @Override
    public String toString() {
        return "V" + this.orderNumber + " (Computer " + super.getName() + ") ";
    }

    @Override
    public String getIPAddress() {
        return ipAddress;
    }

    @Override
    public void setIPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public double getStorage() {
        return storageCapacity;
    }

    @Override
    public void setStorage(double storageValue) {
        this.storageCapacity = storageValue;
    }

}
