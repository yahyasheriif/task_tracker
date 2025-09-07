package com.yahya.task_tracker.controller;
import com.yahya.task_tracker.entity.Task;
import com.yahya.task_tracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;


    @GetMapping("/tasks")
    public List<Task> findAllTasks() {
        return taskService.fetchAllTasks();
    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id,task);
    }

    @PostMapping("/tasks")
    public String createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

}