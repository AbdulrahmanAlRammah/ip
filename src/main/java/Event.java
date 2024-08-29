public class Event extends Task {
    protected String starttime;
    protected String endtime;

    public Event(String description, String starttime, String endtime) {
        super(description);
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Event(boolean status, String description, String starttime, String endtime) {
        super(description, status);
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public String toString() {
        return "[E]" + super.toString() + " from: " + this.starttime + " to: " + this.endtime;
    }

    public String toStorage() {
        return "E," + super.toStorage() + "," + starttime + "," + endtime;
    }
}
