package laborator3.homework.model;

import laborator3.homework.constans.UnitsOfStorage;
import laborator3.homework.model.interfaces.Identifiable;
import laborator3.homework.model.interfaces.Storage;

/**
 * Created by Alexoaie Adrian Sebastian
 * The computer class extends the Node class and implements the Identifiable class and the Storage class because
 * the class has to return an ip Address and The storage capacity
 * The class has two constructors, setters and getters and overrides the toString method
 */

public class Computer extends Node implements Identifiable, Storage, Comparable<Computer> {
    private String ipAddress;
    private double storageCapacity;
    private final int orderNumber;

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

    /**
     * Part of the homework
     * This function converts the storage between different units
     * @param unitsOfStorage is "base" we want to use for conversion
     * @return the converted storage
     */
    @Override
    public double convertStorage(UnitsOfStorage unitsOfStorage) {
        switch (unitsOfStorage) {
            case MEGABYTE:
                return this.getStorage() * 1024;
            case KILOBYTE:
                return this.getStorage() * Math.pow(1024, 2);
            case BYTE:
                return this.getStorage() * Math.pow(1024, 3);
        }
        return 0;
    }

    @Override
    public int compareTo(Computer o) {
        if (this.ipAddress == null || o.getIPAddress() == null) {
            return 0;
        }
        return this.ipAddress.compareTo(o.getIPAddress());
    }

}
