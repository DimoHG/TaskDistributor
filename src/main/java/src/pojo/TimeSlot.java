package src.pojo;

public class TimeSlot {
    private int startTime;
    private int endTime;
    private Parent assignee;
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

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public Parent getAssignee() {
        return assignee;
    }

    public void setAssignee(Parent assignee) {
        this.assignee = assignee;
    }
}
