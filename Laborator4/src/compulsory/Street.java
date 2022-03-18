package compulsory;

public class Street {
    private String name;
    private int length;
    private Intersection head;
    private Intersection tail;

    public Street(String name, int length, Intersection head, Intersection tail) {
        this.name = name;
        this.length = length;
        this.head = head;
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", head=" + head.getName() +
                ", tail=" + tail.getName() +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Intersection getHead() {
        return head;
    }

    public Intersection getTail() {
        return tail;
    }
}
