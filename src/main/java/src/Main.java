package src;

import src.exceptions.ImpossibleDistributionException;
import src.io.ConsoleInputReader;
import src.io.ConsoleOutputWriter;
import src.io.InputReader;
import src.io.OutputWriter;
import src.pojo.TimeSlot;
import src.taskDistributor.OrderedTaskDistributor;
import src.taskDistributor.TaskDistributor;

import java.util.List;

public class Main {
    static InputReader reader = new ConsoleInputReader();
    static OutputWriter writer = new ConsoleOutputWriter();
    static TaskDistributor taskDistributor = new OrderedTaskDistributor();

    public static void main(String[] args) {
        int numberOfTests = reader.readNumberOfTestCases();
        for (int i = 1; i <= numberOfTests; i++) {
            List<TimeSlot> timeSlots = reader.readTimeSlots();
            try {
                timeSlots = taskDistributor.distributeTasks(timeSlots);
                writer.printTaskDistributionCase(timeSlots, i);
            } catch (ImpossibleDistributionException e) {
                writer.printImpossibleCase(i);
            }
        }
    }

}
