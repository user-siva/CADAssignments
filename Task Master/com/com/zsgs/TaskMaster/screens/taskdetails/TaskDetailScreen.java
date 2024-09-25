package com.com.zsgs.TaskMaster.screens.taskdetails;

import com.com.zsgs.TaskMaster.BaseScreen;
import com.com.zsgs.TaskMaster.dto.Task;
import java.util.Scanner;

public class TaskDetailScreen extends BaseScreen {
    private TaskDetailViewModel viewModel;

    public TaskDetailScreen() {
        viewModel = new TaskDetailViewModel(this);
    }

    public void onCreate(Task task) {
        viewModel.setTask(task);
        showTaskDetails(task);
    }

    public void showTaskDetails(Task task) {
        System.out.println("Task Details");
        System.out.println("Name: " + task.getName());
        System.out.println("Description: " + task.getDescription());
        System.out.println("Priority: " + task.getPriority());
        System.out.println("Deadline: " + task.getDeadline());

        System.out.println("1. Mark as Completed");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            viewModel.markTaskAsCompleted();
            showInfoMessage("Task marked as completed.");
        }
    }

    public void onTaskUpdated(Task task) {
        showInfoMessage("Task updated successfully!");
        showTaskDetails(task);
    }
}
