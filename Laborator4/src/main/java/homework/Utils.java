package homework;

import java.util.HashSet;
import java.util.Set;

public class Utils {
    public static <T> Set<T> convertArrayToSet(T array[]) {
        Set<T> set = new HashSet<>();
        for (T t : array) {
            set.add(t);
        }
        return set;
    }
}
