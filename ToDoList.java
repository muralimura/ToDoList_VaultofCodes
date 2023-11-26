import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    // Method to add a task
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Method to delete a task
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String deletedTask = tasks.remove(index);
            System.out.println("Task deleted: " + deletedTask);
        } else {
            System.out.println("Invalid index. Task not deleted.");
        }
    }

    // Method to display the list of tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks in the list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Method to mark a task as complete
    public void markTaskAsComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            String completedTask = tasks.get(index);
            tasks.set(index, "[Completed] " + completedTask);
            System.out.println("Task marked as complete: " + completedTask);
        } else {
            System.out.println("Invalid index. Task not marked as complete.");
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== ToDo List Menu =====");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    toDoList.addTask(taskToAdd);
                    break;
                case 2:
                    System.out.print("Enter index of task to delete: ");
                    int indexToDelete = scanner.nextInt();
                    toDoList.deleteTask(indexToDelete - 1); // Adjust index for user readability
                    break;
                case 3:
                    toDoList.displayTasks();
                    break;
                case 4:
                    System.out.print("Enter index of task to mark as complete: ");
                    int indexToMarkComplete = scanner.nextInt();
                    toDoList.markTaskAsComplete(indexToMarkComplete - 1); // Adjust index for user readability
                    break;
                case 5:
                    System.out.println("Exiting ToDo List application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
