package laborator3.homework.utils;

import laborator3.homework.model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexoaie Adrian Sebastian
 * Nothing to see here... :)
 */
public class Graph {
    private List<Node> nodes = new ArrayList<>();

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
}
