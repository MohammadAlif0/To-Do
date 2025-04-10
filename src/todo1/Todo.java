
package todo1;

import java.util.List;
import java.util.Scanner;

public class Todo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("\n==== To-Do List ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    taskManager.addTask(name, description, priority);
                }

                case 2 -> {
                    List<Task> tasks = taskManager.getTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\n==== Task List ====");
                        for (Task task : tasks) {
                            System.out.println(task.getId() + ". " + task.getName() +
                                    " (" + task.getPriority() + ") - " +
                                    (task.isCompleted() ? "✅ Completed" : "❌ Pending"));
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Enter Task ID to mark as completed: ");
                    int completeId = scanner.nextInt();
                    taskManager.markTaskCompleted(completeId);
                }

                case 4 -> {
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskManager.deleteTask(deleteId);
                }

                case 5 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

