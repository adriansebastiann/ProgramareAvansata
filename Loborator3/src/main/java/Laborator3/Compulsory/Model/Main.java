package Laborator3.Compulsory.Model;

/**
 * Here, in the main class, is tested the functionality of the network class
 */
public class Main {
    public static void main(String[] args) {
        Computer c1 = new Computer();
        c1.setName("A");
        Computer c2 = new Computer();
        c1.setName("B");
        Computer c3 = new Computer();
        c1.setName("B");
        Router r1 = new Router();
        r1.setName("C");
        Router r2 = new Router();
        r1.setName("D");
        Switch s1 = new Switch();
        s1.setName("E");
        Switch s2 = new Switch();
        s1.setName("F");
        Network network = new Network();
        network.addNodesToNetwork(c1);network.addNodesToNetwork(c2);network.addNodesToNetwork(c3);
        network.addNodesToNetwork(r1);network.addNodesToNetwork(r2);
        network.addNodesToNetwork(s1);network.addNodesToNetwork(s2);
        System.out.println(network);



    }
}
