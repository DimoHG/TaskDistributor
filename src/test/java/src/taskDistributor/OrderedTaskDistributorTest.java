package src.taskDistributor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.exceptions.ImpossibleDistributionException;
import src.pojo.Parent;
import src.pojo.TimeSlot;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderedTaskDistributorTest {
    OrderedTaskDistributor taskDistributor = new OrderedTaskDistributor();

    @Test
    void distributeTasksWithoutOverlap(){
        TimeSlot timeSlot1 = new TimeSlot(1, 10, 1);
        TimeSlot timeSlot2 = new TimeSlot(10, 20, 2);
        TimeSlot timeSlot3 = new TimeSlot(20, 30, 3);
        List<TimeSlot> timeSlots = Arrays.asList(timeSlot1, timeSlot2, timeSlot3);
        timeSlots = taskDistributor.distributeTasks(timeSlots);
        assertEquals(Parent.CAMERON, timeSlots.get(0).getAssignee());
        assertEquals(Parent.CAMERON, timeSlots.get(2).getAssignee());
        assertEquals(Parent.CAMERON, timeSlots.get(1).getAssignee());
    }

    @Test
    void distributeTasksWithOverlap(){
        TimeSlot timeSlot1 = new TimeSlot(1, 15, 1);
        TimeSlot timeSlot2 = new TimeSlot(10, 20, 2);
        TimeSlot timeSlot3 = new TimeSlot(20, 30, 3);
        List<TimeSlot> timeSlots = Arrays.asList(timeSlot1, timeSlot2, timeSlot3);
        timeSlots = taskDistributor.distributeTasks(timeSlots);
        assertEquals(Parent.CAMERON, timeSlots.get(0).getAssignee());
        assertEquals(Parent.JAMIE, timeSlots.get(1).getAssignee());
        assertEquals(Parent.JAMIE, timeSlots.get(2).getAssignee());
    }

    @Test
    void distributeShouldFail(){
        TimeSlot timeSlot1 = new TimeSlot(1, 15, 1);
        TimeSlot timeSlot2 = new TimeSlot(1, 15, 2);
        TimeSlot timeSlot3 = new TimeSlot(1, 15, 3);
        List<TimeSlot> timeSlots = Arrays.asList(timeSlot1, timeSlot2, timeSlot3);
        Assertions.assertThrows(ImpossibleDistributionException.class,
                () -> taskDistributor.distributeTasks(timeSlots));
    }

    @Test
    void documentTestCase1(){
        TimeSlot timeSlot1 = new TimeSlot(360, 480, 1);
        TimeSlot timeSlot2 = new TimeSlot(420, 540, 2);
        TimeSlot timeSlot3 = new TimeSlot(600, 660, 3);
        List<TimeSlot> timeSlots = Arrays.asList(timeSlot1, timeSlot2, timeSlot3);
        timeSlots = taskDistributor.distributeTasks(timeSlots);
        assertEquals(Parent.CAMERON, timeSlots.get(0).getAssignee());
        assertEquals(Parent.JAMIE, timeSlots.get(1).getAssignee());
        assertEquals(Parent.JAMIE, timeSlots.get(2).getAssignee());
    }

    @Test
    void documentTestCase2(){
        TimeSlot timeSlot1 = new TimeSlot(0, 1440, 1);
        TimeSlot timeSlot2 = new TimeSlot(1, 3, 2);
        TimeSlot timeSlot3 = new TimeSlot(2, 4, 3);
        List<TimeSlot> timeSlots = Arrays.asList(timeSlot1, timeSlot2, timeSlot3);
        Assertions.assertThrows(ImpossibleDistributionException.class,
                () -> taskDistributor.distributeTasks(timeSlots));
    }

    @Test
    void documentTestCase3(){
        TimeSlot timeSlot1 = new TimeSlot(99, 150, 1);
        TimeSlot timeSlot2 = new TimeSlot(1, 100, 2);
        TimeSlot timeSlot3 = new TimeSlot(100, 301, 3);
        TimeSlot timeSlot4 = new TimeSlot(2, 5, 4);
        TimeSlot timeSlot5 = new TimeSlot(150, 250, 5);
        List<TimeSlot> timeSlots = Arrays.asList(timeSlot1, timeSlot2, timeSlot3, timeSlot4, timeSlot5);
        timeSlots = taskDistributor.distributeTasks(timeSlots);
        assertEquals(Parent.JAMIE, timeSlots.get(0).getAssignee());
        assertEquals(Parent.CAMERON, timeSlots.get(1).getAssignee());
        assertEquals(Parent.CAMERON, timeSlots.get(2).getAssignee());
        assertEquals(Parent.JAMIE, timeSlots.get(3).getAssignee());
        assertEquals(Parent.JAMIE, timeSlots.get(4).getAssignee());
    }

    @Test
    void documentTestCase4(){
        TimeSlot timeSlot1 = new TimeSlot(0, 720, 1);
        TimeSlot timeSlot2 = new TimeSlot(720, 1440, 2);
        List<TimeSlot> timeSlots = Arrays.asList(timeSlot1, timeSlot2);
        timeSlots = taskDistributor.distributeTasks(timeSlots);
        assertEquals(Parent.CAMERON, timeSlots.get(0).getAssignee());
        assertEquals(Parent.CAMERON, timeSlots.get(1).getAssignee());
    }
}
