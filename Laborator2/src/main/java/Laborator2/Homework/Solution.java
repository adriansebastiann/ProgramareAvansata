package Laborator2.Homework;

import Laborator2.Homework.Resources.Event;
import Laborator2.Homework.Resources.Room;
import Laborator2.Homework.Resources.Type;
import Laborator2.Homework.Rooms.ComputerLab;
import Laborator2.Homework.Rooms.DefaultMeetingRoom;
import Laborator2.Homework.Rooms.LectureHall;
import Laborator2.Homework.Rooms.Rooms;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains an instance of the problem and try to resolve it
 * For each event is assigned a room, we don't keep in count the hour of the event
 * We give to the event the room for a full day :))
 * I know that we could minimize the number but...
 */

public class Solution {
    private Problem problem;
    private List<Rooms> neededRooms;
    private List<Rooms> availableRooms;


    public Solution(Problem problem) {
        this.problem = problem;
        neededRooms = new ArrayList<>();
    }

    public boolean existsARequiredRoomInList(Type type) {
        for(Rooms room : neededRooms) {
            if(room.getName().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public Rooms returnProperRoom(Event event) {
        for(Rooms room : problem.getListOfRooms()) {
            if(room.returnRoomType().equals(event.getNeededRoomType()) &&
                room.getCapacity() >= event.getNumberOfParticipants()) {
                return room;
            }
        }
        return null;
    }

    public void assignRoomsFromList() {
        List<Event> events = problem.getListOfEvents();
        int indexOfRoom = 1;
        for(Event event : events) {
            availableRooms.add(returnProperRoom(event));
        }
    }

    public void generateNeededRoomsForEvents() {
        List<Event> events = problem.getListOfEvents();
        int indexOfRoom = 1;
        for(Event event : events) {
            if(event.getNeededRoomType().equals(Type.LABORATORY) && existsARequiredRoomInList(Type.LABORATORY)) {
                neededRooms.add(new ComputerLab("C" + indexOfRoom, 30, "linux"));
            } else if(event.getNeededRoomType().equals(Type.LECTURE_HALL) && existsARequiredRoomInList(Type.LECTURE_HALL)) {
                neededRooms.add(new LectureHall("L" + indexOfRoom, 25, true));
            } else if(event.getNeededRoomType().equals(Type.DEFAULT) && existsARequiredRoomInList(Type.DEFAULT)) {
                neededRooms.add(new DefaultMeetingRoom("D" + indexOfRoom, 45));
            }
            indexOfRoom ++;
        }
    }

    public List<Rooms> returnNeededRooms() {
        return  neededRooms;
    }

    public List<Rooms> getAvailableRooms() {
        return availableRooms;
    }
}
