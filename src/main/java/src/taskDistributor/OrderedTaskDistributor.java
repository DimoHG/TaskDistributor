package src.taskDistributor;

import src.exceptions.ImpossibleDistributionException;
import src.pojo.TimeSlot;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class OrderedTaskDistributor implements TaskDistributor {
    final static Logger logger = Logger.getLogger(OrderedTaskDistributor.class.getName());

    @Override
    public List<TimeSlot> distributeTasks(List<TimeSlot> timeSlots) {
        timeSlots.sort(Comparator.comparing(TimeSlot::getStartTime));
        String currentParent = "C";
        timeSlots.get(0).setAssignee(currentParent);
        for (int i = 1; i < timeSlots.size(); i++) {
            if (areSlotsOverlapping(timeSlots.get(i - 1), timeSlots.get(i))) {
                currentParent = "J".equals(currentParent) ? "C" : "J";
                if (i >= 2 && areSlotsOverlapping(timeSlots.get(i - 2), timeSlots.get(i))) {
                    throw new ImpossibleDistributionException();
                }
            }
            timeSlots.get(i).setAssignee(currentParent);
        }
        timeSlots.sort(Comparator.comparing(TimeSlot::getOrdinal));
        return timeSlots;
    }

    private boolean areSlotsOverlapping(TimeSlot firstTimeSlot, TimeSlot secondTimeSlot) {
        return firstTimeSlot.getEndTime() > secondTimeSlot.getStartTime();
    }
}
