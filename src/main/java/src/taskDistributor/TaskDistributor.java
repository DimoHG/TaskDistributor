package src.taskDistributor;

import src.pojo.TimeSlot;

import java.util.List;

public interface TaskDistributor {
    List<TimeSlot> distributeTasks(List<TimeSlot> timeSlots);
}
