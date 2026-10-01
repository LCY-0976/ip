/**
 * Represents a generic task with a name and completion status.
 */
public class Task {
    protected boolean isDone = false;
    protected String name;

    /**
     * Constructs a new Task with the specified name.
     *
     * @param name the name or description of the task
     */
    public Task(String name) {
        this.name = name;
    }

    /**
     * Marks the task as completed.
     */
    public void done() {
        isDone = true;
    }

    /**
     * Marks the task as not completed.
     */
    public void undone() {
        isDone = false;
    }

    /**
     * Returns the completion status of the task.
     *
     * @return true if the task is completed, false otherwise
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Returns the name of the task.
     *
     * @return the task name
     */
    public String getName() {
        return name;
    }

    /**
     * Prints the formatted status and description of the task.
     */
    public void printStatus() {
        String status = isDone ? "[X]" : "[ ]";
        System.out.printf("%s %s\n", status, name);
    }
}