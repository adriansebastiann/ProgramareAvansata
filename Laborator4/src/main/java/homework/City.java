package homework;

import org.jgrapht.*;
import org.jgrapht.alg.spanning.*;
import org.jgrapht.graph.*;
import org.jgrapht.graph.builder.*;
import org.jgrapht.util.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class illustrating the city
 */
public class City {

    private List<Street> streets;               //the list of streets from the city
    Graph<String, DefaultWeightedEdge> city;    //graph, the intersections are the vertexes, the length of the streets is the weight

    public City(Set<Intersection> intersections, List<Street> streets) {
        this.streets = streets;

        //build the graph with required proprieties
        city = GraphTypeBuilder.undirected().weighted(true).allowingMultipleEdges(false).allowingSelfLoops(false)
                .vertexSupplier(SupplierUtil.createStringSupplier())
                .edgeSupplier(SupplierUtil.createDefaultWeightedEdgeSupplier())
                .buildGraph();

        //add the vertexes to the graph
        for (Intersection intersection : intersections) {
            city.addVertex(intersection.getName());
        }

        //add the edges with weight to the graph
        for (Street street : streets) {
            DefaultWeightedEdge edge = city.addEdge(street.getIntersections().get(0).getName(),
                    street.getIntersections().get(1).getName());
            city.setEdgeWeight(edge, street.getLength());
        }
    }

    //find the streets with required length using streams
    public List<Street> streetsBiggerThan(int length) {
        return streets.stream()
                .filter(street -> street.getLength() > length)
                .collect(Collectors.toList());
    }

    //find the minimum spanning tree using Kruskal algorithm and print the edges
    public void findSolution() {
        for (DefaultWeightedEdge e : new KruskalMinimumSpanningTree<>(city).getSpanningTree()) {
            System.out.println(e);
        }
    }
}
