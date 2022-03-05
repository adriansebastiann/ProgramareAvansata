package Laborator2.Compulsory;

/**
 * Created by Alexoaie Adrian
 * The event class has its attributes, setters and getters, two constructors and overrides the toString method
 */
public class Event {
    private String eventName;
    private int numberOfParticipants;
    private MyHour startHour;
    private MyHour endHour;

    public Event() {
        this.eventName = "Movie night";
        this.numberOfParticipants = 10;
        this.startHour = new MyHour();
        this.endHour = new MyHour(2, 30);
    }

    public Event(String eventName, int numberOfParticipants, MyHour startHour, MyHour endHour) {
        this.eventName = eventName;
        this.numberOfParticipants = numberOfParticipants;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", numberOfParticipants=" + numberOfParticipants +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                '}';
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

}
