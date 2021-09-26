package src.io;

import src.pojo.TimeSlot;

import java.util.List;

public class ConsoleOutputWriter implements OutputWriter{

    @Override
    public void printTaskDistribution(List<TimeSlot> timeSlotList, int caseOrdinal) {
        System.out.printf("Case #%d: ", caseOrdinal);
        timeSlotList.forEach(slot -> System.out.print(slot.getAssignee()));
        System.out.println();
    }

    @Override
    public void printImpossibleCase(int caseOrdinal) {
        System.out.printf("Case #%d: IMPOSSIBLE%n", caseOrdinal);
    }


}
