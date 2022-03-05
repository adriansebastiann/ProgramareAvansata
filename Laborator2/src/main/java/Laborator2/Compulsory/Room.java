package Laborator2.Compulsory;

/**
 * Created by Alexoaie Adrian
 * This class illustrates the room where the events will take place
 * It has his own attributes, constructors, setters and getters and overrides the toString() method
 */
public class Room {
    private String name;
    private int capacity;
    private Type type;

    public Room() {
        this.name = "Meeting Room";
        this.capacity = 50;
        this.type = Type.DEFAULT;
    }

    public Room(String name, int capacity, Type type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", type=" + type +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
