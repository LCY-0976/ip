import java.util.Scanner;
public class Chris {
    private static final int CAPACITY = 100;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[] todo =  new String[CAPACITY];
    private static final boolean[] isDone = new boolean[CAPACITY];
    private static int count = 0;
    private static boolean isEnd;
    public static void main(String[] args) {
        showWelcomeMessage();
        while (!isEnd) {
            String userInput = getUserInput();
            echoUserCommand(userInput);
        }
    }
    private static void showWelcomeMessage(){
        String banner ="  ______  __         _     \n"
                + " / ____/ / /_  _____(_)____\n"
                + "/ /   / __ \\/ ___/ / ___/\n"
                + "/ /___/ / / / /  / (__  ) \n"
                + "\\____/_/ /_/_/  /_/____/  \n";
        System.out.println(banner);
        System.out.println("Hello,I am Chris.\n");
        System.out.println("What can I do for you?\n");
        System.out.println("--------------------\n");
    }
    private static String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
    private static void echoUserCommand(String input){
        String[] parts = input.split("\\s+");
        String command = parts[0];
        System.out.println("--------------------\n");
        switch (command) {
            case "bye":
                System.out.println("Bye. Hope to see you again soon!");
                isEnd = true;
                break;
            case "list":
                System.out.println("Here are the tasks in your list:\n");
                for(int i = 0; i < count; i++){
                    String finishSymbol = isDone[i] ? "[X]" : "[ ]";
                    System.out.printf("%d.%S%s\n",i+1,finishSymbol,todo[i]);
                }
                break;
            case "mark":
                if (parts.length > 1) {
                    try {
                        int index = Integer.parseInt(parts[1]);
                        System.out.println("Nice! I've marked this task as done:\n");
                        System.out.println("[X]"+todo[index-1]);
                        isDone[index-1] = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Task number must be a valid integer!");
                    }
                } else {
                    System.out.println("Error: Missing task number! Usage: mark <number>");
                }
                break;
            case "unmark":
                if (parts.length > 1) {
                    try {
                        int index = Integer.parseInt(parts[1]);
                        System.out.println("OK, I've marked this task as not done yet:\n");
                        System.out.println("[ ]"+todo[index-1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Task number must be a valid integer!");
                    }
                } else {
                    System.out.println("Error: Missing task number! Usage: unmark <number>");
                }
                break;
            default:
                if(count == CAPACITY){
                    System.out.println("Todo list is full!");
                }else {
                    System.out.println("added : " + command + "\n");
                    todo[count] = command;
                    count++;
                }
            }
        System.out.println("--------------------\n");
    }
}



