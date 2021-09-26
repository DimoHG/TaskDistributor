package src.io;

import src.pojo.TimeSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputReader implements InputReader{
    private final Scanner scan;

    public ConsoleInputReader() {
        this.scan = new Scanner(System.in);
    }

    @Override
    public int readNumberOfTestCases() {
        return Integer.parseInt(scan.nextLine());
    }

    @Override
    public int readNumberOfTasks() {
        return Integer.parseInt(scan.nextLine());
    }

    @Override
    public List<TimeSlot> readTimeSlots() {
        int numberOfSlots = readNumberOfTasks();
        ArrayList<TimeSlot> timeSlots = new ArrayList<>();
        for (int i = 1; i <= numberOfSlots; i++) {
            String[] input = scan.nextLine().split(" ");
            int startTime = Integer.parseInt(input[0]);
            int endTime = Integer.parseInt(input[1]);
            TimeSlot currentTimeSlot = new TimeSlot(startTime, endTime, i);
            timeSlots.add(currentTimeSlot);
        }
        return timeSlots;
    }

}
