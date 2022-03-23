package project.Laborator1.Homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexoaie Adrian Sebastian
 * This class is used to store the neighbors of a word
 * Using the index from list of word and the index of the MyList array we know the neighbors of every word
 */
public class MyList {
    String
    private List<String> list;

    /**
     * default constructor
     */
    public MyList() {
        list = new ArrayList<>();
    }

    /**
     * getter to return the list from th class
     * @return the list
     */
    public List<String> getMyList() {
        return list;
    }

    /**
     * used to add elements to the list
     * @param element the element which is going to be added to the list
     */
    public void addElementToList(String element) {
        list.add(element);
    }
}
