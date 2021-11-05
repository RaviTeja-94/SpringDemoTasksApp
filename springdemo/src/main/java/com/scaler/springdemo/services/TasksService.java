package com.scaler.springdemo.services;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TasksService {

    @AllArgsConstructor
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PRIVATE)
    public static class Task {
        String name;
        boolean done;
    }

    List<Task> tasks =  new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public int addTask (String name) {
        Task task = new Task(name, false);
        tasks.add(task);
        return tasks.indexOf(task);
    }

    public Task getTask(int id) {
        return tasks.get(id); //check for id not existing
    }

    public boolean setTaskDone(int id, boolean isDone) {
        Task task = tasks.get(id); //check for id not existing
        if(task != null) {
            task.setDone(isDone);
        }
        return task.isDone();
    }

}
