import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> normalTasks;
    private PriorityQueue<PriorityTask> priorityTasks;
    private Scanner scanner; 
    public TaskManager() {
        normalTasks = new ArrayList<>();
        priorityTasks = new PriorityQueue<>();
        scanner = new Scanner(System.in);
    }
    public void addTask(String taskName) {
        System.out.print("What is the task?");
        String description = scanner.nextLine();
        Task newTask = new Task(taskName, description);
        System.out.print("Would you like to add this task to the priority list? (yes/no): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            System.out.print("Enter priority # (ordered from lowest to highest number): ");
            int priority = Integer.parseInt(scanner.nextLine());
            PriorityTask pTask = new PriorityTask(newTask, priority);
            priorityTasks.add(pTask);
            System.out.println("Added to priority list.");
        } else {
            normalTasks.add(newTask);
            System.out.println("Added to normal list.");
        }
    }
    public void viewTasks() {
        int taskNumber = 1;
        System.out.println("\n Priority Tasks");
        if (priorityTasks.isEmpty()) {
            System.out.println("No priority tasks.");
        } else {
            List<PriorityTask> sortedPriority = new ArrayList<>(priorityTasks);
            Collections.sort(sortedPriority);
            for (PriorityTask pt : sortedPriority) {
                System.out.println(taskNumber + ". ");
                pt.getTask().printTask();
                System.out.println("Priority: " + pt.getPriority());
                System.out.println("____________________"); //seperate
                taskNumber++;
            }
        }
        System.out.println("\n Normal Tasks");
        if (normalTasks.isEmpty()) {
            System.out.println("No normal tasks.");
        } else {
            for (Task t : normalTasks) {
                System.out.println(taskNumber + ". ");
                t.printTask();
                System.out.println("__________________________");
                taskNumber++;
            }
        }
    }
}