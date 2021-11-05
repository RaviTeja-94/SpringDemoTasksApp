package com.scaler.springdemo.tasks;

import com.scaler.springdemo.services.TasksService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.util.AssertionErrors;

public class TasksServiceTests {

    private TasksService getTaskService() {
        return new TasksService();
    }

    @Test
    void testAddTask() {
        String name = "task1";
        TasksService tasksService = getTaskService();
        int taskID = tasksService.addTask(name);
        Assertions.assertEquals(0,taskID);
    }

    @Test
    void testGetTask() {
        String name = "task1";
        TasksService tasksService = getTaskService();
        int taskID = tasksService.addTask(name);
        Assertions.assertNotNull(tasksService.getTask(taskID));
    }

    @Test
    void testSetTaskToDone() {
        String name = "task1";
        TasksService tasksService = getTaskService();
        int taskID = tasksService.addTask(name);
        Assertions.assertTrue(tasksService.setTaskDone(taskID,true));
    }
}
