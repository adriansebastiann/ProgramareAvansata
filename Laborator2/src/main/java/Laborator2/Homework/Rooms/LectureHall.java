package Laborator2.Homework.Rooms;

import Laborator2.Homework.Resources.Type;
/**
 *  Created by Alexoaie Adrian-Sebastian
 *  This class extends Rooms class and is used for assigning to events
 *  It has a containsVideoProjector variable besides the parent class
 */
public class LectureHall extends Rooms{
    private boolean containsVideoProjector;

    public LectureHall(String name, int capacity, boolean containsVideoProjector) {
        super(name, capacity);
        this.containsVideoProjector = containsVideoProjector;
    }

    @Override
    public String toString() {
        return "LectureHall{" +
                "containsVideoProjector=" + containsVideoProjector +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public boolean isContainsVideoProjector() {
        return containsVideoProjector;
    }

    public void setContainsVideoProjector(boolean containsVideoProjector) {
        this.containsVideoProjector = containsVideoProjector;
    }

    @Override
    public String getName() {
       return name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        super.capacity = capacity;
    }

    @Override
    public Type returnRoomType() {
        return Type.LECTURE_HALL;
    }
}
