package Laborator2.Homework;

import Laborator2.Compulsory.MyHour;
import Laborator2.Homework.Resources.Event;
import Laborator2.Homework.Resources.Room;
import Laborator2.Homework.Resources.Type;
import Laborator2.Homework.Rooms.ComputerLab;
import Laborator2.Homework.Rooms.DefaultMeetingRoom;
import Laborator2.Homework.Rooms.LectureHall;
import Laborator2.Homework.Rooms.Rooms;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Alexoaie Adrian Sebastian
 * Here we test the functionality of the solution class
 * The class doesn't do too much so there is only one test
 * This is a sneak peek for testNG dependency :)))
 */
public class Tests {

    @Test()
    public void testSolution(){
        List<Event> events = new ArrayList<>();
        events.add(new Event("Laboratory JAVA", 27, new MyHour(12,30), new MyHour(14,30), "1234", Type.LABORATORY));
        events.add(new Event("Curs JAVA", 27, new MyHour(15, 0), new MyHour(17, 0), "2345", Type.LECTURE_HALL));
        events.add(new Event("Coffee", 15, new MyHour(16, 30), new MyHour(0,0), "party", Type.DEFAULT));

        List<Rooms> rooms = new ArrayList<>();
        rooms.add(new LectureHall("l1", 30, true));
        rooms.add(new ComputerLab("c2", 35, "linux"));
        rooms.add(new DefaultMeetingRoom());

        Problem problem = new Problem(rooms, events);
        Solution solution = new Solution(problem);
        System.out.println(solution.returnNeededRooms());

        Assert.assertEquals(solution.returnNeededRooms().size(), problem.getListOfEvents().size());
    }

}
