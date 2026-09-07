import java.util.Scanner;

public class Chris {
    private static final int CAPACITY = 100;
    private static final Scanner SCANNER;
    private static final Task[] tasks = new Task[CAPACITY];
    private static int count = 0;
    private static boolean isEnd;

    public Chris() {
    }

    public static void main(String[] args) {
        showWelcomeMessage();

        while(!isEnd) {
            String userInput = getUserInput();
            echoUserCommand(userInput);
        }

    }

    private static void showWelcomeMessage() {
        String banner = "  ______  __         _     \n / ____/ / /_  _____(_)____\n/ /   / __ \\/ ___/ / ___/\n/ /___/ / / / /  / (__  ) \n\\____/_/ /_/_/  /_/____/  \n";
        System.out.println(banner);
        System.out.println("Hello,I am Chris.\n");
        System.out.println("What can I do for you?\n");
        System.out.println("--------------------\n");
    }

    private static String getUserInput() {
        return SCANNER.nextLine();
    }

    private static void echoUserCommand(String input) {
        String name;
        String date;
        String command = input.split(" ")[0];
        String remaining = input.substring(input.indexOf(command)+command.length());
        System.out.println("--------------------\n");
        switch (command) {
            case "bye":
                System.out.println("Bye. Hope to see you again soon!");
                isEnd = true;
                break;
            case "todo":
                String todoName = remaining.trim();
                if (todoName.isEmpty()) {
                    System.out.println("Please input the task's name.");
                    break; // Exit the switch case so the task is not created
                }
                tasks[count] = new Todo(todoName);
                System.out.println("Got it. I've added this task:");
                tasks[count].printStatus();
                count++;
                System.out.printf("Now you have %d tasks in the list.\n", count);
                break;
            case "deadline":
                try {
                    date = remaining.substring(remaining.indexOf("/by") + 3);
                    name = remaining.substring(0, remaining.indexOf("/by"));
                    tasks[count] = new Deadline(name,date);
                    System.out.println("Got it. I've added this task:");
                    tasks[count].printStatus();
                    count++;
                    System.out.printf("Now you have %d tasks in the list.\n",count);
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Please enter a valid date in the Format /by day-month-year");
                }
                break;
            case "event":
                try {
                    name = remaining.substring(0, remaining.indexOf("/from"));
                    String from = remaining.substring(remaining.indexOf("/from") + 5, remaining.indexOf("/to"));
                    String to = remaining.substring(remaining.indexOf("/to") + 3);
                    tasks[count] = new Event(name, from, to);
                    System.out.println("Got it. I've added this task:");
                    tasks[count].printStatus();
                    count++;
                    System.out.printf("Now you have %d tasks in the list.\n", count);
                }catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Please enter a valid date in the Format /from xxxx /to xxxx");
                }
                break;
            case "list":
                System.out.println("Here are the tasks in your list:\n");
                for(int i = 0; i < count; ++i) {
                    System.out.printf("%d.",i+1);
                    tasks[i].printStatus();
                }
                break;
            case "mark":
                        int index = Integer.parseInt(remaining);
                        System.out.println("Nice! I've marked this task as done:\n");
                        tasks[index-1].done();
                        tasks[index-1].printStatus();
                        break;
            case "unmark":
                        int idx = Integer.parseInt(remaining);
                        System.out.println("OK, I've marked this task as not done yet:\n");
                        tasks[idx-1].undone();
                        tasks[idx-1].printStatus();
                        break;
            default:
               System.out.println("Error: no command is received.");
        }

        System.out.println("--------------------\n");
    }

    static {
        SCANNER = new Scanner(System.in);
    }
}




