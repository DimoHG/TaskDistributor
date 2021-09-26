package src.io;

import src.pojo.TimeSlot;

import java.util.List;

public interface OutputWriter {
    void printTaskDistribution(List<TimeSlot> timeSlots, int caseOrdinal);
    void printImpossibleCase(int caseOrdinal);
}
