package Project;
import java.io.*;
import java.util.*;

public class FileHandler {
    
    public List<Task> loadTasks(String fileName) {
        List<Task> tasks = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            // Read each line from the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Split the line into task components (TaskName|Priority|DueDate)
                String[] taskData = line.split("\\|");


                if (taskData.length == 3) {
                    String taskName = taskData[0];
                    int priority = Integer.parseInt(taskData[1]);
                    String dueDate = taskData[2];

                    // Create a Task object and add it to the list
                    Task task = new Task(taskName, priority, dueDate);
                    tasks.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return tasks;
    }


    public void saveTasks(List<Task> tasks, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Task task : tasks) {

                writer.println(task.getTaskName() + "|" + task.getPriority() + "|" + task.getDueDate());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}