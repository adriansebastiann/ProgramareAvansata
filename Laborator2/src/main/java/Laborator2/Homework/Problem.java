package Laborator2.Homework;

import Laborator2.Homework.Resources.Event;
import Laborator2.Homework.Resources.Room;
import Laborator2.Homework.Rooms.Rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Alexoaie Adrian Sebastian
 * This class is the problem that needs to be solved, it contains a list of events and a list rooms
 */
public class Problem {
    private List<Rooms> listOfRooms;
    private List<Event> listOfEvents;

    public Problem() {
        this.listOfRooms = new ArrayList<>();
        this.listOfEvents = new ArrayList<>();
    }

    public Problem(List<Rooms> listOfRooms, List<Event> listOfEvents) {
        this.listOfRooms = listOfRooms;
        this.listOfEvents = listOfEvents;
    }

    public void addEventToList(Event event) {
        listOfEvents.add(event);
    }

    public void addRoomToList(Rooms room) {
        listOfRooms.add(room);
    }

    public List<Rooms> getListOfRooms() {
        return listOfRooms;
    }

    public void setListOfRooms(List<Rooms> listOfRooms) {
        this.listOfRooms = listOfRooms;
    }

    public List<Event> getListOfEvents() {
        return listOfEvents;
    }

    public void setListOfEvents(List<Event> listOfEvents) {
        this.listOfEvents = listOfEvents;
    }
}
