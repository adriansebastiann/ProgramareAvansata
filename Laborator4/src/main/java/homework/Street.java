package homework;

import java.util.ArrayList;
import java.util.List;

public class Street {
    private String name;
    private int length;
    private List<Intersection> intersections;

    public Street(String name, int length, Intersection v0,Intersection v1) {
        this.name = name;
        this.length = length;
        this.intersections = new ArrayList<>();
        this.intersections.add(v0);
        this.intersections.add(v1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Intersection> getIntersections() {
        return intersections;
    }

    public void setIntersections(List<Intersection> intersections) {
        this.intersections = intersections;
    }

    @Override
    public String toString() {
        return name;
    }
}
