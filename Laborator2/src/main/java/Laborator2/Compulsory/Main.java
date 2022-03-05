package Laborator2.Compulsory;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

/**
 * Created by Alexoaie Adrian
 * Here we test the main functionalities of the project
 */
public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Event event = new Event();
        System.out.println(event.toString());
        logger.debug(event.toString());

        Room room =  new Room();
        System.out.println(room.toString());
    }
}
