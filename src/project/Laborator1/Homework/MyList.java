package project.Laborator1.Homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexoaie Adrian Sebastian
 * This class is used to store the neighbors of a word
 * Using the index from list of word and the index of the MyList array we know the neighbors of every word
 */
public class MyList {
    private List<String> list;

    public MyList() {
        list = new ArrayList<>();
    }

    public List<String> getMyList() {
        return list;
    }

    public void addElementToList(String element) {
        list.add(element);
    }
}
