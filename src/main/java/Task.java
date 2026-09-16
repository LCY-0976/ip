public class Task {
    protected boolean isDone = false;
    protected String name;
    public Task(String name) {
        this.name = name;
    }
    public void done() {
        isDone = true;
    }
    public void undone() {
        isDone = false;
    }
    public boolean isDone() {
        return isDone;
    }
    public String getName() {
        return name;
    }
    public void printStatus() {
        String status = isDone ? "[X]" : "[ ]";
        System.out.printf("%s %s\n", status, name);
    }
}