package com.com.zsgs.TaskMaster.datalayer;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.com.zsgs.TaskMaster.dto.Task;

public class TaskMasterRepository {
    private static TaskMasterRepository repository;

    private TaskMasterRepository() {

    }

    public static TaskMasterRepository getInstance() {

        if (repository == null) {
            repository = new TaskMasterRepository();
        }

        return repository;
    }

    public List<Task> getTaskList() {
        Task task1 = new Task("task 1", "do leetcode", 1, LocalDateTime.now());
        Task task2 = new Task("task 2", "watch movie", 1, LocalDateTime.now());
        Task task3 = new Task("task 3", "repeat", 1, LocalDateTime.now());

        return Arrays.asList(task1, task2, task3);
    }

    public boolean isLoggedIn() {
        return false;
    }
}
