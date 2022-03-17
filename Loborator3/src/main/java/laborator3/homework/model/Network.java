package laborator3.homework.model;

import laborator3.homework.model.interfaces.Identifiable;
import laborator3.homework.utils.BestProbability;
import laborator3.homework.utils.DijkstraAlgorithm;
import laborator3.homework.utils.Graph;

import java.util.*;

/**
 * Created by Alexoaie Adrian Sebastian
 * This class implements the functionality of network
 */
public class Network {

    /**
     * There are a list of nodes from the network and a set of node names because the nodes can't have an existing name
     */

    private List<Node> nodes;                             //the list of nodes from network
    private Set<String> nodeNames;                        //a set with the names of the nodes, used to make sure that there are no repeated names
    private List<Identifiable> listOfIdentifiableObjects; //the list of teh nodes that implements identifiable interface

    /**
     * There are constructors, setter and getters, an addNodesToNetwork method and the toString method override
     */
    public Network() {
        this.nodes = new ArrayList<>();
        this.nodeNames = new HashSet<>();
        this.listOfIdentifiableObjects = new ArrayList<>();
    }

    public Network(List<Node> nodes) {
        this.nodes = nodes;
        this.listOfIdentifiableObjects = new ArrayList<>();
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

    /**
     * Function that prints the whole network
     */
    public void printNetwork() {
        for(Node node : this.nodes) {
            Iterator hmIterator = node.getNeighborsAndCosts().entrySet().iterator();
            System.out.print("The node: " + node.getName() + " has this neighbors with costs: ");
            while(hmIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry)hmIterator.next();
                int costs = (int)mapElement.getValue();
                // Printing mark corresponding to string entries
                System.out.print("[Node:" + mapElement.getKey() + " Cost:" + costs + "] ");
            }
            System.out.println(" ");
        }
    }

    /**
     * function that builds the list of identifiable nodes than sorts the list using Collection sort
     * @return the sorted list of identifiable objects
     */
    public List<Identifiable> returnListOfIdentifiableObjects() {

        for(Node node : nodes) {
            if(node instanceof Identifiable) {
                listOfIdentifiableObjects.add((Identifiable) node);
            }
        }
        Collections.sort(listOfIdentifiableObjects, new Comparator<Identifiable>() {
            @Override
            public int compare(Identifiable o1, Identifiable o2) {
                return o1.getIPAddress().compareTo(o2.getIPAddress());
            }
        });
        return listOfIdentifiableObjects;
    }

    /**
     * This function uses DijkstraAlgorithm to print the shortest path between two nodes
     * @param startNode
     * @param endNode
     */
    public void printShortestPathBetweenThisNodes(Node startNode, Node endNode) {
        DijkstraAlgorithm.calculateShortestPathFromSource(startNode);

        for(Node node : nodes) {
            if(node.equals(endNode)) {
                System.out.println("The shortest path from " + startNode + " to " + node + " is " + node.getShortestPath() +
                                    " and has the value: " + node.getDistance());
            }
        }

    }

    /**
     * This function prints the path with the best probability to succeed
     * @param startNode
     * @param endNode
     */
    public void printBestProbabilityPathBetweenThisNodes(Node startNode, Node endNode) {
        BestProbability.calculateShortestPathFromSource(startNode);
        for(Node node : nodes) {
            if(node.equals(endNode)) {
                System.out.println("The best probability path from " + startNode + " to " + node + " is " + node.getTheBestProbabilityPath() +
                        " and has the value: " + node.getProbability());
            }
        }

    }

    public Node getNodeByIndex(int index) {
        return nodes.get(index);
    }


    @Override
    public String toString() {
        return nodes + " ";
    }
}
