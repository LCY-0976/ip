/**
 * Represents an event task that occurs within a specific time frame.
 */
public class Event extends Task {
    private final String from;
    private final String to;

    /**
     * Constructs a new Event task with a name, start time, and end time.
     *
     * @param name the description of the event
     * @param from the start time or date of the event
     * @param to   the end time or date of the event
     */
    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the combined start and end date range of the event.
     *
     * @return the date range string in the format "from-to"
     */
    public String getDate(){
        return this.from + "-" + this.to;
    }

    /**
     * Prints the formatted status, description, and time interval for the event.
     */
    @Override
    public void printStatus(){
        String status = isDone ? "[X]" : "[ ]";
        System.out.printf("[E]%s %s (from: %s to: %s)\n",status,name,from,to);
    }
}