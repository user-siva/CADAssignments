package com.com.zsgs.TaskMaster;

import com.com.zsgs.TaskMaster.datalayer.TaskMasterRepository;
import com.com.zsgs.TaskMaster.screens.tasklist.TaskListScreen;
import com.com.zsgs.TaskMaster.screens.login.*;

public class TaskMaster {
    private static TaskMaster taskmaster;

    private TaskMaster() {

    }

    public String appName = "Task Master Application";

    public String appVersion = "0.0.4";

    public int appVersionCode = 4;

    public static TaskMaster getInstance() {
        if (taskmaster == null) {
            taskmaster = new TaskMaster();
        }
        return taskmaster;
    }

    public static void main(String arg[]) {
        TaskMaster.getInstance().onCreate();
    }

    public void onCreate() {
        if (TaskMasterRepository.getInstance().isLoggedIn()) {
            TaskListScreen taskListScreen = new TaskListScreen();
            taskListScreen.onCreate();
        } else {
            LoginView loginScreen = new LoginView();
            loginScreen.onCreate();
        }
    }

}
