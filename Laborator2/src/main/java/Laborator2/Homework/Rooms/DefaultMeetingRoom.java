package Laborator2.Homework.Rooms;

import Laborator2.Homework.Resources.Type;
/**
 *  Created by Alexoaie Adrian-Sebastian
 *  This class extends Rooms class and is used for assigning to events
 *  This room is used for events that don't have any required room or have a required room, but we don't have it
 *  Doesn't have anything besides classic atributes
 */
public class DefaultMeetingRoom extends Rooms{

    public DefaultMeetingRoom() {
    }

    public DefaultMeetingRoom(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public String toString() {
        return "DefaultMeetingRoom{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
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
        return Type.DEFAULT;
    }
}
