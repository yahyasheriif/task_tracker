package com.yahya.task_tracker.service;
import com.yahya.task_tracker.entity.Task;
import com.yahya.task_tracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> fetchAllTasks() {
        return taskRepository.findAll();
    }

    public String updateTask(Long id ,Task task) {
        Task curTask = taskRepository.findById(id).orElse(null);
        if(curTask!=null) {
            curTask.setName(task.getName());
            curTask.setDescription(task.getDescription());
            curTask.setStatus(task.getStatus());
            taskRepository.save(curTask);
            return "Task updated successfully";
        }
        return "Task not found";
    }

    public String createTask(@Validated Task task ) {
        try {
            taskRepository.save(task);
            return "Task created successfully";
        } catch (Exception e) {
            return "Error occurred while creating task";
        }
    }

    public String deleteTask(Long id) {
        Task curTask = taskRepository.findById(id).orElse(null);
        if(curTask == null) {
            return "Task not found";
        }
        taskRepository.delete(curTask);
        return "Task deleted successfully";
    }
}
