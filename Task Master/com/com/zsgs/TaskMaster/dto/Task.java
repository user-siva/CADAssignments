package com.com.zsgs.TaskMaster.dto;

import java.time.LocalDateTime;
import java.util.*;

public class Task {
    private String name;
    private String description;
    private int priority;
    private LocalDateTime deadline;
    private List<Task> dependencies;
    boolean isCompleted;

    public Task(String name, String description, int priority, LocalDateTime deadline) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        dependencies = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return this.priority;
    }

    public LocalDateTime getDeadline() {
        return this.deadline;
    }

    public void setCompleted() {
        this.isCompleted = true;
    }

    public void addDependencies(Task task) {
        this.dependencies.add(task);
    }

    public boolean hasDependencies() {
        return !dependencies.isEmpty();
    }
}
