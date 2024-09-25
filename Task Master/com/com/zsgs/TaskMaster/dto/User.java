package com.com.zsgs.TaskMaster.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String email;
    String password;
    List<Task> tasks;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        tasks = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void addTask(Task t) {
        this.tasks.add(t);
    }
}
