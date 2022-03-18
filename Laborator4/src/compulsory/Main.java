package compulsory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Intersection dummy = new Intersection("1");
        List<Street> streets = new LinkedList<>();
        streets.add(new Street("Soarelui", 10, dummy, new Intersection("2")));
        streets.add(new Street("Iernii", 15, new Intersection("3"), new Intersection("4")));
        streets.add(new Street("Creativitate", 12, dummy, new Intersection("6")));
        streets.add(new Street("Frunzei", 14, dummy, new Intersection("8")));

        Stream<Street> streamOfStreets = Stream.of(
                new Street("Soarelui", 10, new Intersection("1"), new Intersection("2")),
                new Street("Iernii", 15, new Intersection("3"), new Intersection("4")),
                new Street("Creativitate", 12, new Intersection("5"), new Intersection("6")),
                new Street("Frunzei", 14, new Intersection("7"), new Intersection("8"))
        );

        //create the list of intersections using stream from the street list
        List<Intersection> intersections1 = streets.stream()
                .map(p -> p.getHead())
                .collect(Collectors.toList());

        List<Intersection> intersections = streets.stream()
                .map(p -> p.getTail())
                .collect(Collectors.toList());
        intersections.addAll(intersections1);

        for(Intersection intersection : intersections) {
            System.out.print(intersection.getName() + " ");
        }


        //sort the list of streets by the length
        Collections.sort(streets, Comparator.comparingInt(obj -> obj.getLength()));

        System.out.println();
        for(Street street : streets) {
            System.out.println(street);
        }

        HashSet<Intersection> setOfIntersections = new HashSet<>(intersections);

        for(Intersection intersection : setOfIntersections) {
            System.out.print(intersection.getName() + " ");
        }

        //verify if the set contains duplicates using brute force
        System.out.println();
        System.out.println(Utils.containsDuplicates(setOfIntersections));
    }



}
