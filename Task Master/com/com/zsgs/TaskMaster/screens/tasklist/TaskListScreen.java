package com.com.zsgs.TaskMaster.screens.tasklist;

import java.util.List;
import java.util.Scanner;

import com.com.zsgs.TaskMaster.BaseScreen;
import com.com.zsgs.TaskMaster.dto.Task;
import com.com.zsgs.TaskMaster.screens.taskdetails.TaskDetailScreen;

public class TaskListScreen extends BaseScreen {
    private TaskListViewModel viewModel;

    public TaskListScreen() {
        viewModel = new TaskListViewModel(this);
    }

    public void onCreate() {
        viewModel.onCreate();
    }

    public void showTaskList(List<Task> TaskList) {
        System.out.println("List of Tasks");
        int index = 1;
        for (Task Task : TaskList) {
            System.out.println(index + ". " + Task.getName());
            System.out.println("Description: " + Task.getDescription());
            System.out.println("Priority: " + Task.getPriority());
            System.out.println("Deadline: " + Task.getDeadline());
            index++;
        }
        System.out.println(index + 1 + ". Exit");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int position = scanner.nextInt();
            if (position == index + 1) {
                showAlertMessage("Thank You");
                System.exit(0);
            } else if (position > TaskList.size()) {
                showAlertMessage("Invalid Entry, Please try again");
                continue;
            }
            viewModel.onTaskSelected(TaskList.get(position - 1));
            break;
        }
    }

    public void navigateToTaskDetails(Task task) {
        TaskDetailScreen taskDetailScreen = new TaskDetailScreen();
        taskDetailScreen.onCreate(task);

    }

}
