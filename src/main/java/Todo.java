/**
 * Represents a todo task without any specific date or time constraint.
 */
public class Todo extends Task {
    /**
     * Constructs a new Todo task with the specified name.
     *
     * @param name the name of the todo task
     */
    public Todo(String name){
        super(name);
    }

    /**
     * Prints the formatted status and description specific to a todo task.
     */
    @Override
    public void printStatus() {
        String status = isDone? "[X]" : "[ ]";
        System.out.println("[T]" + status + name);
    }
}