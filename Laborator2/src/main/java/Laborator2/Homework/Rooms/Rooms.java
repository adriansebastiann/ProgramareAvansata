package Laborator2.Homework.Rooms;

import Laborator2.Homework.Resources.Type;
/**
 *  Created by Alexoaie Adrian-Sebastian
 *  This is an abstract class that we use to create list of rooms for event
 *  there are 3 classes that inherits this one
 */
public abstract class Rooms {
    String name;
    int capacity;

    public Rooms() {
        this.name = "Meeting Hall";
        this.capacity = 45;
    }

    public Rooms(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public abstract String getName();
    public abstract void setName(String name);
    public abstract int getCapacity();
    public abstract void setCapacity(int capacity);
    public abstract Type returnRoomType();
}
