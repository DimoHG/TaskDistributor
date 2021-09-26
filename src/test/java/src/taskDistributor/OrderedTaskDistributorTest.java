package src.taskDistributor;

import org.junit.jupiter.api.Test;
import src.pojo.TimeSlot;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderedTaskDistributorTest {
    OrderedTaskDistributor taskDistributor = new OrderedTaskDistributor();

    @Test
    void distributeTasksWithoutOverlap(){
        List<TimeSlot> timeSlots = new ArrayList<>();
        TimeSlot timeSlot1 = new TimeSlot(1, 10, 1);
        TimeSlot timeSlot2 = new TimeSlot(10, 20, 2);
        TimeSlot timeSlot3 = new TimeSlot(20, 30, 3);
        timeSlots.add(timeSlot1);
        timeSlots.add(timeSlot2);
        timeSlots.add(timeSlot3);
        timeSlots = taskDistributor.distributeTasks(timeSlots);
        assertTrue(timeSlots.get(0).getAssignee().equals("C"));
        assertTrue(timeSlots.get(1).getAssignee().equals("C"));
        assertTrue(timeSlots.get(2).getAssignee().equals("C"));
    }

    @Test
    void distributeTasksWithOverlap(){
        List<TimeSlot> timeSlots = new ArrayList<>();
        TimeSlot timeSlot1 = new TimeSlot(1, 15, 1);
        TimeSlot timeSlot2 = new TimeSlot(10, 20, 2);
        TimeSlot timeSlot3 = new TimeSlot(20, 30, 3);
        timeSlots.add(timeSlot1);
        timeSlots.add(timeSlot2);
        timeSlots.add(timeSlot3);
        timeSlots = taskDistributor.distributeTasks(timeSlots);
        assertTrue(timeSlots.get(0).getAssignee().equals("C"));
        assertTrue(timeSlots.get(1).getAssignee().equals("J"));
        assertTrue(timeSlots.get(2).getAssignee().equals("J"));
    }

    @Test
    void distributeShouldFail(){
        List<TimeSlot> timeSlots = new ArrayList<>();
        TimeSlot timeSlot1 = new TimeSlot(1, 15, 1);
        TimeSlot timeSlot2 = new TimeSlot(1, 15, 2);
        TimeSlot timeSlot3 = new TimeSlot(1, 15, 3);
        timeSlots.add(timeSlot1);
        timeSlots.add(timeSlot2);
        timeSlots.add(timeSlot3);
        timeSlots = taskDistributor.distributeTasks(timeSlots);
    }
}
