
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Task Manager Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    taskManager.addTask(taskName);
                    break;

                case "2":
                    taskManager.viewTasks();
                    break;

                case "3":
                    System.out.print("Enter task index to delete: ");
                    int indexToDelete = Integer.parseInt(scanner.nextLine());
                    taskManager.deleteTask(indexToDelete);
                    break;

                case "4":
                    running = false;
                    System.out.println("Exiting Task Manager.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }
}
