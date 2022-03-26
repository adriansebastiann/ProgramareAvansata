package compulsory;

import java.util.HashSet;

/**
 * Testing with brute force the propriety of unique elements from a HashSet
 */
public class Utils {
    public static boolean containsDuplicates(HashSet<Intersection> hashSet) {
        Intersection[] intersections = hashSet.toArray(new Intersection[hashSet.size()]);
        for(int index = 0; index < hashSet.size(); index ++) {
            for(int jndex = 0; jndex < hashSet.size(); jndex ++) {
                if(intersections[index].getName().equals(intersections[jndex]) && index != jndex) {
                    return true;
                }
            }
        }
        return false;
    }
}
