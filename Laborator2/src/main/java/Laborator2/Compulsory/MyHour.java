package Laborator2.Compulsory;

/**
 * Created by Alexoaie Adrian
 * This class was created to make things a little complicated when we need to book an event
 * This class has constructors, setters and getters and overrides the toString() method
 * Also contains some methods to help us to decide the chronological order of hours
 */
public class MyHour {
    private int hour;
    private int minutes;

    public MyHour() {
        this.hour = 0;
        this.minutes = 0;
    }

    public MyHour(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "MyHour{" +
                "hour=" + hour +
                ", minutes=" + minutes +
                '}';
    }

    public boolean isEarlier(MyHour myHour) {
        if (this.hour < myHour.getHour()) {
            return true;
        } else if (this.hour == myHour.getHour() &&
                this.minutes < myHour.getMinutes()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLater(MyHour myHour) {
        if (this.hour > myHour.getHour()) {
            return true;
        } else if (this.hour == myHour.getHour() &&
                this.minutes > myHour.getMinutes()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean areTheHoursEqual(MyHour myHour) {
        return (this.hour == myHour.getHour()) && (this.minutes == myHour.getMinutes());
    }
}
