package src.io;

import src.pojo.TimeSlot;

import java.util.List;

public interface InputReader {
    int readNumberOfTestCases();
    int readNumberOfTasks();
    List<TimeSlot> readTimeSlots();
}
