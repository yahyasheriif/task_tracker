package com.yahya.task_tracker.service;
import com.yahya.task_tracker.entity.Task;
import com.yahya.task_tracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;


@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> fetchAllTasks() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        List<Task> tasks = taskRepository.findByUsername(username);
        return tasks;
    }

    public String updateTask(Long id ,Task task) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        if(!taskRepository.findById(id).orElse(null).getUserName().equals(username)) {
            return "You are not authorized to update this task";
        }
        Task curTask = taskRepository.findById(id).orElse(null);
        if(curTask==null) {
            return "Task not found";
        }
            curTask.setName(task.getName());
            curTask.setDescription(task.getDescription());
            curTask.setStatus(task.getStatus());
            taskRepository.save(curTask);
            return "Task updated successfully";
    }

    public String createTask(@Validated Task task ) {
        try {
            task.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
            taskRepository.save(task);
            return "Task created successfully";
        } catch (Exception e) {
            return "Error occurred while creating task";
        }
    }

    public String deleteTask(Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        if(!taskRepository.findById(id).orElse(null).getUserName().equals(username)) {
            return "You are not authorized to delete this task";
        }
        Task curTask = taskRepository.findById(id).orElse(null);
        if(curTask == null) {
            return "Task not found";
        }
        taskRepository.delete(curTask);
        return "Task deleted successfully";
    }
}
