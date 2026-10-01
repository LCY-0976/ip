/**
 * Represents a task that needs to be completed by a specific deadline.
 */
public class Deadline extends Task {
    private final String deadline;

    /**
     * Constructs a new Deadline task with a name and a deadline time/date.
     *
     * @param name     the description of the deadline task
     * @param deadline the deadline date or time
     */
    public Deadline(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    /**
     * Returns the deadline date or time string.
     *
     * @return the deadline string
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * Prints the formatted status, description, and deadline for the task.
     */
    @Override
    public void printStatus(){
        String status = isDone ? "[X]" : "[ ]";
        System.out.printf("[D]%s %s (by: %s)\n",status,name,deadline);
    }
}