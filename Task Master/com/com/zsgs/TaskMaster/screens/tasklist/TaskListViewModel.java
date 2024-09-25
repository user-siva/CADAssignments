package com.com.zsgs.TaskMaster.screens.tasklist;

import java.util.ArrayList;
import java.util.List;

import com.com.zsgs.TaskMaster.BaseScreen;
import com.com.zsgs.TaskMaster.TaskMaster;
import com.com.zsgs.TaskMaster.datalayer.TaskMasterRepository;
import com.com.zsgs.TaskMaster.dto.Task;

public class TaskListViewModel extends BaseScreen {
    private TaskListScreen view;
    private Task tasks;

    TaskListViewModel(TaskListScreen t) {
        this.view = t;
    }

    public void onCreate() {
        if (hasNetworkConnection()) {
            view.showTaskList(TaskMasterRepository.getInstance().getTaskList());
        }
    }

    public void onTaskSelected(Task task) {
        view.navigateToTaskDetails(task);
        this.tasks = task;
    }
}
