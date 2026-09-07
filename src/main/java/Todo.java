public class Todo extends Task{
    public Todo(String name){
        super(name);
    }
    @Override
    public void printStatus() {
        String status = isDone? "[X]" : "[ ]";
        System.out.println("[T]" + status + name);
    }
}