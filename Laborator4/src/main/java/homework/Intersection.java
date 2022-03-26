package homework;

public class Intersection implements Comparable {

    private String name;

    public Intersection(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(o.toString());
    }
}