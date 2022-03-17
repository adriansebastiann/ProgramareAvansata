package laborator3.homework.utils;

import laborator3.homework.model.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created By Alexoaie Adrian Sebastian
 * This is for the bonus part
 * Is similar with Dijkstra's algorithm, but we calculate  the product of the probabilities, and we look for the biggest one
 */
public class BestProbability {

    private static Node getBiggestProbability(Set<Node> unsettledNodes) {
        Node bestProbNode = null;
        double bestProb = Double.MIN_VALUE;
        for (Node node: unsettledNodes) {
            double nodeProb = node.getProbability();
            if (nodeProb > bestProb) {
                bestProb = nodeProb;
                bestProbNode = node;
            }
        }
        return bestProbNode;
    }

    private static void calculateBestProbability(Node evaluationNode, Double edgeWeigh, Node sourceNode) {
        Double sourceProb = sourceNode.getProbability();
        if (sourceProb + edgeWeigh > evaluationNode.getProbability()) {
            evaluationNode.setProbability(sourceProb * edgeWeigh);
            LinkedList<Node> bestProbPath = new LinkedList<>(sourceNode.getTheBestProbabilityPath());
            bestProbPath.add(sourceNode);
            evaluationNode.setTheBestProbabilityPath(bestProbPath);
        }
    }

    public static void calculateShortestPathFromSource(Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getBiggestProbability(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Double> adjacencyPair : currentNode.getProbabilities().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Double edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateBestProbability(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
    }

}
