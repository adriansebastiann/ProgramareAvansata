package Laborator3.Compulsory.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alexoaie Adrian Sebastian
 * This class implements the functionality of network
 */
public class Network {

    /**
     * There are a list of nodes from the network and a set of node names because the nodes can't have an existing name
     */
    private List<Node> nodes;
    private Set<String> nodeNames;

    /**
     * There are constructors, setter and getters, an addNodesToNetwork method and the toString method override
     */
    public Network() {
        this.nodes = new ArrayList<>();
        this.nodeNames = new HashSet<>();
    }

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNodesToNetwork(Node node) {
        if(nodeNames.add(node.getName())) {
            nodes.add(node);
        }
    }

    @Override
    public String toString() {
        return nodes + " ";
    }
}
