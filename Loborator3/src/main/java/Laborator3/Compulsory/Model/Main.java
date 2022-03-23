package laborator3.compulsory.model;

/**
 * Here, in the main class, is tested the functionality of the network class
 */
public class Main {
    public static void main(String[] args) {
        Computer c1 = new Computer("s1", "1", "A", "123231", 1234);
        Computer c2 = new Computer("s2", "2", "B", "1233431", 134);
        Computer c3 = new Computer("s3", "3", "B", "1232234231", 123434);
        Router r1 = new Router("s4", "4", "C", "123231");
        Router r2 = new Router("s5", "5", "D", "123232431");
        Switch s1 = new Switch("s6", "6", "E");
        Switch s2 = new Switch("s7", "7", "F");
        Network network = new Network();

        network.addNodesToNetwork(c1);network.addNodesToNetwork(c2);network.addNodesToNetwork(c3);
        network.addNodesToNetwork(r1);network.addNodesToNetwork(r2);
        network.addNodesToNetwork(s1);network.addNodesToNetwork(s2);
        System.out.println(network);



    }
}
