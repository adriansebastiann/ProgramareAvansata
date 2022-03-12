package Laborator3.Compulsory.Model;

import Laborator3.Compulsory.Interfaces.Identifiable;
import Laborator3.Compulsory.Interfaces.Storage;

/**
 * Created by Alexoaie Adrian Sebastian
 * The computer class extends the Node class and implements the Identifiable class and the Storage class because
 * the class has to return an ip Address and The storage capacity
 * The class has two constructors, setters and getters and overrides the toString method
 */

public class Computer extends Node implements Identifiable, Storage {
    private String ipAddress;
    private double storageCapacity;

    public Computer(String hardwareAddress, String locationOnTheMap, String name, String ipAddress, double storageCapacity) {
        super(hardwareAddress, locationOnTheMap, name);
        this.ipAddress = ipAddress;
        this.storageCapacity = storageCapacity;
    }

    public Computer() {
    }

    @Override
    public String toString() {
        return "V" + super.counter + " (Computer " + super.getName() + ") ";
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
