package src.pojo;

public class TimeSlot {
    private int startTime;
    private int endTime;
    private String assignee;
    private int ordinal;


    public TimeSlot(int startTime, int endTime, int ordinal) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.ordinal = ordinal;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }
}
