import java.io.*;
import java.util.Scanner;

public class Chris {
    private static final int CAPACITY = 100;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Task[] tasks = new Task[CAPACITY];
    private static int count = 0;
    private static boolean isEnd;
    private static String HARDCODEDfileName = "./data/duke.txt";

    public static void main(String[] args) {
        showWelcomeMessage();
        load(HARDCODEDfileName);
        while (!isEnd) {
            String userInput = getUserInput();
            echoUserCommand(userInput);
        }
        try {
            save(HARDCODEDfileName);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private static void showWelcomeMessage() {
        String banner = "  ______  __         _     \n / ____/ / /_  _____(_)____\n/ /   / __ \\/ ___/ / ___/\n/ /___/ / / / /  / (__  ) \n\\____/_/ /_/_/  /_/____/  \n";
        System.out.println(banner);
        System.out.println("Hello, I am Chris.\n");
        System.out.println("What can I do for you?\n");
        System.out.println("--------------------\n");
    }

    private static String getUserInput() {
        return SCANNER.nextLine();
    }

    private static void save(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (tasks[i] instanceof Todo) {
                sb.append("T | ").append(tasks[i].isDone()).append(" | ").append(tasks[i].getName()).append("\n");
            } else if (tasks[i] instanceof Deadline) {
                sb.append("D | ").append(tasks[i].isDone()).append(" | ").append(tasks[i].getName())
                        .append(" | ").append(((Deadline) tasks[i]).getDeadline()).append("\n");
            } else if (tasks[i] instanceof Event) {
                String[] dates = ((Event) tasks[i]).getDate().split("-");
                String from = dates.length > 0 ? dates[0] : "";
                String to = dates.length > 1 ? dates[1] : "";
                sb.append("E | ").append(tasks[i].isDone()).append(" | ").append(tasks[i].getName())
                        .append(" | ").append(from).append(" | ").append(to).append("\n");
            }
        }

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(sb.toString());
        }
    }

    private static void load(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("No saved data found. Starting with an empty task list.");
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(" \\| ");
                if (parts.length < 3) continue;

                String type = parts[0];
                boolean isDone = Boolean.parseBoolean(parts[1]);
                String name = parts[2];

                Task task = null;
                switch (type) {
                    case "T":
                        task = new Todo(name);
                        break;
                    case "D":
                        if (parts.length >= 4) {
                            task = new Deadline(name, parts[3]);
                        }
                        break;
                    case "E":
                        if (parts.length >= 5) {
                            task = new Event(name, parts[3], parts[4]);
                        }
                        break;
                }

                if (task != null && count < CAPACITY) {
                    if (isDone) {
                        task.done();
                    }
                    tasks[count++] = task;
                }
            }
            System.out.println("Successfully loaded " + count + " tasks from storage.");
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void echoUserCommand(String input) {
        String[] splitInput = input.split(" ", 2);
        String command = splitInput[0];
        String remaining = splitInput.length > 1 ? splitInput[1] : "";

        System.out.println("--------------------\n");
        switch (command) {
            case "bye":
                System.out.println("Bye. Hope to see you again soon!");
                isEnd = true;
                break;
            case "todo":
                if (count < CAPACITY) {
                    tasks[count] = new Todo(remaining);
                    System.out.println("Got it. I've added this task:");
                    tasks[count++].printStatus();
                }
                break;
            case "deadline":
                if (remaining.contains("/by") && count < CAPACITY) {
                    String date = remaining.substring(remaining.indexOf("/by") + 3).trim();
                    String name = remaining.substring(0, remaining.indexOf("/by")).trim();
                    tasks[count] = new Deadline(name, date);
                    System.out.println("Got it. I've added this task:");
                    tasks[count++].printStatus();
                    System.out.printf("Now you have %d tasks in the list.\n", count);
                }
                break;
            case "event":
                if (remaining.contains("/from") && remaining.contains("/to") && count < CAPACITY) {
                    String name = remaining.substring(0, remaining.indexOf("/from")).trim();
                    String from = remaining.substring(remaining.indexOf("/from") + 5, remaining.indexOf("/to")).trim();
                    String to = remaining.substring(remaining.indexOf("/to") + 3).trim();
                    tasks[count] = new Event(name, from, to);
                    System.out.println("Got it. I've added this task:");
                    tasks[count++].printStatus();
                    System.out.printf("Now you have %d tasks in the list.\n", count);
                }
                break;
            case "list":
                System.out.println("Here are the tasks in your list:\n");
                for (int i = 0; i < count; ++i) {
                    System.out.printf("%d.", i + 1);
                    tasks[i].printStatus();
                }
                break;
            case "mark":
                try {
                    int index = Integer.parseInt(remaining) - 1;
                    if (index >= 0 && index < count) {
                        System.out.println("Nice! I've marked this task as done:\n");
                        tasks[index].done();
                        tasks[index].printStatus();
                    }
                } catch (NumberFormatException ignored) {}
                break;
            case "unmark":
                try {
                    int idx = Integer.parseInt(remaining) - 1;
                    if (idx >= 0 && idx < count) {
                        System.out.println("OK, I've marked this task as not done yet:\n");
                        tasks[idx].undone();
                        tasks[idx].printStatus();
                    }
                } catch (NumberFormatException ignored) {}
                break;
            default:
                System.out.println("Error: no command is received.");
        }
        System.out.println("--------------------\n");
    }
}