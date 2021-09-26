package src;

import src.io.ConsoleInputReader;
import src.io.ConsoleOutputWriter;
import src.io.InputReader;
import src.io.OutputWriter;
import src.pojo.Parent;
import src.taskDistributor.OrderedTaskDistributor;
import src.taskDistributor.TaskDistributor;

public class Main {
    static InputReader reader = new ConsoleInputReader();
    static OutputWriter writer = new ConsoleOutputWriter();
    static TaskDistributor taskDistributor = new OrderedTaskDistributor();

//    public static void main(String[] args) {
//        int numberOfTests = reader.readNumberOfTestCases();
//        for (int i = 1; i <= numberOfTests; i++) {
//            List<TimeSlot> timeSlots = reader.readTimeSlots();
//            try {
//                timeSlots = taskDistributor.distributeTasks(timeSlots);
//                writer.printTaskDistribution(timeSlots, i);
//            } catch (ImpossibleDistributionException e) {
//                writer.printImpossibleCase(i);
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(Parent.CAMERON.getShortName());
    }

}
