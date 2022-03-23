package laborator3.homework.model;

import laborator3.homework.constans.UnitsOfStorage;
import laborator3.homework.utils.Graph;

/**
 * Here, in the main class, is tested the functionality of the network class
 */
public class Main {
    public static void main(String[] args) {

        Computer c1 = new Computer("s1", "1", "1", "123231", 1234);
        Computer c2 = new Computer("s2", "2", "2", "1233431", 134);
        Router r3 = new Router("s4", "4", "3", "123231");
        Router r4 = new Router("s5", "5", "4", "123232431");
        Switch s5 = new Switch("s6", "6", "5");
        Switch s6 = new Switch("s7", "7", "6");
        c1.addEdge(c2, 10);
        c1.addEdge(r3, 50);
        c2.addEdge(c1, 10);
        c2.addEdge(r3, 20);
        c2.addEdge(s5, 20);
        c2.addEdge(r4, 20);
        r3.addEdge(c1, 50);
        r3.addEdge(c2, 20);
        r3.addEdge(r4, 10);
        r4.addEdge(c2, 20);
        r4.addEdge(r3, 10);
        r4.addEdge(s5, 30);
        r4.addEdge(s6, 10);
        s5.addEdge(c2, 20);
        s5.addEdge(r4, 30);
        s5.addEdge(s6, 20);
        s6.addEdge(r4, 10);
        s6.addEdge(s5, 20);
        Network network = new Network();
        network.addNodesToNetwork(c1);network.addNodesToNetwork(c2);
        network.addNodesToNetwork(r3);network.addNodesToNetwork(r4);
        network.addNodesToNetwork(s5);network.addNodesToNetwork(s6);
        System.out.println(network);
        network.printNetwork();

        System.out.println("The storage converted from GB to b is: " + c1.convertStorage(UnitsOfStorage.BYTE));

        System.out.println("The sorted list of identifiable nodes is: " + network.returnListOfIdentifiableObjects());

        network.printShortestPathBetweenThisNodes(c2, s6);

        //bonus
        c1.addProbability(c2, 0.1);
        c1.addProbability(r3, 0.5);
        c2.addProbability(c1, 0.1);
        c2.addProbability(r3, 0.2);
        c2.addProbability(s5, 0.2);
        c2.addProbability(r4, 0.2);
        r3.addProbability(c1, 0.5);
        r3.addProbability(c2, 0.2);
        r3.addProbability(r4, 0.1);
        r4.addProbability(c2, 0.2);
        r4.addProbability(r3, 0.1);
        r4.addProbability(s5, 0.3);
        r4.addProbability(s6, 0.1);
        s5.addProbability(c2, 0.2);
        s5.addProbability(r4, 0.3);
        s5.addProbability(s6, 0.2);
        s6.addProbability(r4, 0.1);
        s6.addProbability(s5, 0.2);

        //network.printBestProbabilityPathBetweenThisNodes(c1, s6);

    }
}
