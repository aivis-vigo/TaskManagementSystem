package org.example.taskmanager.services;

import org.example.taskmanager.dto.CreateTaskDTO;
import org.example.taskmanager.models.Task;
import org.example.taskmanager.models.TaskStatus;
import org.example.taskmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(CreateTaskDTO task) {
//        validate(task);
        Task newTask = new Task(task.getKey(), task.getSummary(), task.getType(), TaskStatus.TODO, task.getPriority(), task.getAssignee());
        return taskRepository.save(newTask);
    }

    public Task updateTask(Task task) {
//        validate(task);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
//    private void validate(Task task) {
//        if (task.getKey() == null || task.getKey().isBlank())
//            throw new IllegalArgumentException("Task key cannot be empty");
//    }
}