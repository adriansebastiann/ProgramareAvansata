package Laborator3.Compulsory.Model;

/**
 * Created by Alexoaie Adrian Sebastian
 * This class is the base for all nodes from network
 * There are the common proprieties, setters and getters
 */
public class Node {
    private String hardwareAddress;
    private String locationOnTheMap;
    private String name;
    /**
     * the counter attribute is used to count the number of instances of this class
     * is used to know to number of order for type of node
     */
    protected static int counter;

    public Node() {
        this.counter ++;
    }

    public Node(String hardwareAddress, String locationOnTheMap, String name) {
        this.hardwareAddress = hardwareAddress;
        this.locationOnTheMap = locationOnTheMap;
        this.name = name;
        this.counter ++;
    }

    public String getHardwareAddress() {
        return hardwareAddress;
    }

    public void setHardwareAddress(String hardwareAddress) {
        this.hardwareAddress = hardwareAddress;
    }

    public String getLocationOnTheMap() {
        return locationOnTheMap;
    }

    public void setLocationOnTheMap(String locationOnTheMap) {
        this.locationOnTheMap = locationOnTheMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
