package homework;

import com.github.javafaker.Faker;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

        //generate intersections
        Intersection[] existingIntersections = new Intersection[9];
        existingIntersections[0] = new Intersection("i0");
        existingIntersections[1] = new Intersection("i1");
        existingIntersections[2] = new Intersection("i2");
        existingIntersections[3] = new Intersection("i3");
        existingIntersections[4] = new Intersection("i4");
        existingIntersections[5] = new Intersection("i5");
        existingIntersections[6] = new Intersection("i6");
        existingIntersections[7] = new Intersection("i7");
        existingIntersections[8] = new Intersection("i8");

        List<Street> streets = new LinkedList<>();

        Faker faker = new Faker();

        //generate streets with random names
        streets.add(new Street(faker.name().fullName(), 2, existingIntersections[0], existingIntersections[1]));
        streets.add(new Street(faker.name().fullName(), 2, existingIntersections[0], existingIntersections[2]));
        streets.add(new Street(faker.name().fullName(), 2, existingIntersections[0], existingIntersections[3]));
        streets.add(new Street(faker.name().fullName(), 2, existingIntersections[1], existingIntersections[2]));
        streets.add(new Street(faker.name().fullName(), 1, existingIntersections[2], existingIntersections[3]));
        streets.add(new Street(faker.name().fullName(), 3, existingIntersections[1], existingIntersections[4]));
        streets.add(new Street(faker.name().fullName(), 2, existingIntersections[2], existingIntersections[6]));
        streets.add(new Street(faker.name().fullName(), 3, existingIntersections[3], existingIntersections[5]));
        streets.add(new Street(faker.name().fullName(), 2, existingIntersections[2], existingIntersections[5]));
        streets.add(new Street(faker.name().fullName(), 1, existingIntersections[4], existingIntersections[5]));
        streets.add(new Street(faker.name().fullName(), 3, existingIntersections[5], existingIntersections[8]));
        streets.add(new Street(faker.name().fullName(), 2, existingIntersections[4], existingIntersections[8]));
        streets.add(new Street(faker.name().fullName(), 1, existingIntersections[4], existingIntersections[7]));
        streets.add(new Street(faker.name().fullName(), 1, existingIntersections[6], existingIntersections[8]));
        streets.add(new Street(faker.name().fullName(), 1, existingIntersections[7], existingIntersections[8]));
        streets.add(new Street(faker.name().fullName(), 1, existingIntersections[6], existingIntersections[7]));

        System.out.println(streets.get(5));

        Set<Intersection> intersections = Utils.convertArrayToSet(existingIntersections);

        //build a city
        City city = new City(intersections, streets);

        //test the method that returns the streets with a length bigger than the inserted one
        System.out.println(city.streetsBiggerThan(1));

        //print the solution to the problem
        city.findSolution();

    }
}
