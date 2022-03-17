package laborator3.homework.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexoaie Adrian Sebastian
 * This class is the base for all nodes from network
 * There are the common proprieties, setters and getters
 */
public class Node {
    private String hardwareAddress;
    private String locationOnTheMap;
    private String name;
    private Integer distance = Integer.MAX_VALUE;                   //the distances from start node is set to maximum
    private Double probability = 0.0;                               //the probability is set to 0
    private HashMap<Node, Integer> neighborsAndCosts;               //the neighbors nodes with the cost to reach
    private List<Node> shortestPath = new LinkedList<>();           //here are stored the nodes for the shortest path
    private List<Node> theBestProbabilityPath = new LinkedList<>(); //here are stored the nodes for the best probability path
    private HashMap<Node, Double> probabilities;                    //here are stored the nodes and their probabilities

    /**
     * the counter attribute is used to count the number of instances of this class
     * is used to know to number of order for type of node
     */
    protected static int counter;

    public Node() {
        this.counter ++;
        neighborsAndCosts = new HashMap<>();
        probabilities = new HashMap<>();
    }

    public Node(String hardwareAddress, String locationOnTheMap, String name) {
        this.hardwareAddress = hardwareAddress;
        this.locationOnTheMap = locationOnTheMap;
        this.name = name;
        neighborsAndCosts = new HashMap<>();
        this.counter ++;
        probabilities = new HashMap<>();
    }

    public void addEdge(Node node, int cost) {
        this.neighborsAndCosts.put(node, new Integer(cost));
    }

    public void addProbability(Node node, double probability) {
        this.probabilities.put(node, new Double(probability));
    }

    public String getHardwareAddress() {
        return hardwareAddress;
    }

    public void setHardwareAddress(String hardwareAddress) {
        this.hardwareAddress = hardwareAddress;
    }

    public String getLocationOnTheMap() {
        return locationOnTheMap;
    }

    public void setLocationOnTheMap(String locationOnTheMap) {
        this.locationOnTheMap = locationOnTheMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Node, Integer> getNeighborsAndCosts() {
        return neighborsAndCosts;
    }

    public void setNeighborsAndCosts(HashMap<Node, Integer> neighborsAndCosts) {
        this.neighborsAndCosts = neighborsAndCosts;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public List<Node> getTheBestProbabilityPath() {
        return theBestProbabilityPath;
    }

    public void setTheBestProbabilityPath(List<Node> theBestProbabilityPath) {
        this.theBestProbabilityPath = theBestProbabilityPath;
    }

    public HashMap<Node, Double> getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(HashMap<Node, Double> probabilities) {
        this.probabilities = probabilities;
    }
}
