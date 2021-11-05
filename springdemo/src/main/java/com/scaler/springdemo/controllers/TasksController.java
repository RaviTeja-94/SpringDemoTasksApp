package com.scaler.springdemo.controllers;

import com.scaler.springdemo.services.TasksService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TasksController {

    @Data
    static class AddTaskBody {
        String task;
    }

    @Autowired TasksService tasksService;

    @GetMapping("/")
    List<TasksService.Task> getAllTasks() {
        return tasksService.getAllTasks();
    }

    @GetMapping("/{id}")
    TasksService.Task getSpecificTask(@PathVariable("id") int id) {
        return tasksService.getTask(id);
    }

    @PostMapping("/")
    TasksService.Task  addTask(@RequestBody AddTaskBody body) {
         int taskId = tasksService.addTask(body.task);
         return tasksService.getTask(taskId);
    }

    @PutMapping("/{id}/done")
    TasksService.Task setTaskToDone(@PathVariable("id") int id ) {
        tasksService.setTaskDone(id, true);
        return  tasksService.getTask(id);
    }

    @DeleteMapping("/{id}/done")
    TasksService.Task setTaskToUndone(@PathVariable("id") int id ) {
        tasksService.setTaskDone(id, false);
        return  tasksService.getTask(id);
    }


}
