package Laborator3.Compulsory.Model;

import Laborator3.Compulsory.Interfaces.Identifiable;

/**
 * Created by Alexoaie Adrian Sebastian
 * This class extends the node class, has constructors, setters and getters and overrides the toString method
 */
public class Router extends Node implements Identifiable {
    public String ipAddress;
    private static int counter;

    public Router(String hardwareAddress, String locationOnTheMap, String name, String ipAddress) {
        super(hardwareAddress, locationOnTheMap, name);
        this.ipAddress = ipAddress;
        this.counter ++;
    }

    public Router() {
        this.counter ++;
    }

    @Override
    public String toString() {
        return "V" + super.counter + " (Router " + super.getName() + ") ";
    }

    @Override
    public String getIPAddress() {
        return this.ipAddress;
    }

    @Override
    public void setIPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
