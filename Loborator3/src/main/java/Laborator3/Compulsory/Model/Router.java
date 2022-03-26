package laborator3.compulsory.model;

import laborator3.compulsory.interfaces.Identifiable;

/**
 * Created by Alexoaie Adrian Sebastian
 * This class extends the node class, has constructors, setters and getters and overrides the toString method
 */
public class Router extends Node implements Identifiable {
    public String ipAddress;
    private int orderNumber;

    public Router(String hardwareAddress, String locationOnTheMap, String name, String ipAddress) {
        super(hardwareAddress, locationOnTheMap, name);
        this.ipAddress = ipAddress;
        this.orderNumber = super.counter;
    }

    public Router() {
        this.orderNumber = super.counter;
    }

    @Override
    public String toString() {
        return "V" + this.orderNumber + " (Router " + super.getName() + ") ";
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
