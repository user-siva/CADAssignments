package com.com.zsgs.TaskMaster.screens.taskdetails;

import com.com.zsgs.TaskMaster.dto.Task;

public class TaskDetailViewModel {
    private TaskDetailScreen view;
    private Task task;

    public TaskDetailViewModel(TaskDetailScreen view) {
        this.view = view;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void markTaskAsCompleted() {
        task.setCompleted();
        // view.onTaskUpdated(task);
    }
}
