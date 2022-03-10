package Laborator2.Homework.Resources;

import Laborator2.Compulsory.MyHour;

import java.util.Objects;

/**
 * Created by Alexoaie Adrian
 * The event class has its attributes, setters and getters, two constructors and overrides the toString method
 */
public class Event {
    private String eventID;
    private String eventName;
    private int numberOfParticipants;
    private MyHour startHour;
    private MyHour endHour;
    private Type neededRoomType;

    public Event() {
        this.eventName = "Movie night";
        this.numberOfParticipants = 10;
        this.startHour = new MyHour();
        this.endHour = new MyHour(2, 30);
        this.neededRoomType = Type.DEFAULT;
    }

    public Event(String eventName, int numberOfParticipants, MyHour startHour, MyHour endHour, String eventID, Type type) {
        this.eventName = eventName;
        this.numberOfParticipants = numberOfParticipants;
        this.startHour = startHour;
        this.endHour = endHour;
        this.eventID = eventID;
        this.neededRoomType = type;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", numberOfParticipants=" + numberOfParticipants +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                ", event ID=" + eventID +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return numberOfParticipants == event.numberOfParticipants &&
                Objects.equals(eventID, event.eventID) &&
                Objects.equals(eventName, event.eventName) &&
                Objects.equals(startHour, event.startHour) &&
                Objects.equals(endHour, event.endHour);
    }

    public Type getNeededRoomType() {
        return neededRoomType;
    }

    public void setNeededRoomType(Type neededRoomType) {
        this.neededRoomType = neededRoomType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public MyHour getStartHour() {
        return startHour;
    }

    public void setStartHour(MyHour startHour) {
        this.startHour = startHour;
    }

    public MyHour getEndHour() {
        return endHour;
    }

    public void setEndHour(MyHour endHour) {
        this.endHour = endHour;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }
}
