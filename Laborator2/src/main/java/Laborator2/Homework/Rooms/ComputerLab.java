package Laborator2.Homework.Rooms;

import Laborator2.Homework.Resources.Type;

/**
 *  Created by Alexoaie Adrian-Sebastian
 *  This class extends Rooms class and is used for assigning to events
 *  It has an operatingSystems variable besides the parent class
 */
public class ComputerLab extends Rooms{
    private String operatingSystem;

    public ComputerLab(String name, int capacity, String operatingSystem) {
        super(name, capacity);
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "ComputerLab{" +
                "operatingSystem='" + operatingSystem + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public int getCapacity() {
        return super.capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        super.capacity = capacity;
    }

    @Override
    public Type returnRoomType() {
        return Type.LABORATORY;
    }


}
