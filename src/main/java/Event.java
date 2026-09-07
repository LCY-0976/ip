public class Event extends Task{
    private final String from;
    private final String to;
    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }
    @Override
    public void printStatus(){
        String status = isDone ? "[X]" : "[ ]";
        System.out.printf("[E]%s %s (from: %s to: %s)\n",status,name,from,to);
    }
}