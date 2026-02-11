package org.example.taskmanager.services;

import org.example.taskmanager.dto.CreateTaskDTO;
import org.example.taskmanager.dto.TaskDTO;
import org.example.taskmanager.dto.TaskDTOMapper;
import org.example.taskmanager.models.Task;
import org.example.taskmanager.repositories.TaskRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskDTOMapper taskDTOMapper;

    public TaskService(TaskRepository taskRepository, TaskDTOMapper taskDTOMapper) {
        this.taskRepository = taskRepository;
        this.taskDTOMapper = taskDTOMapper;
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskDTOMapper)
                .toList();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Optional<TaskDTO> getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskDTOMapper);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void createTask(CreateTaskDTO task) {
        Task newTask = taskDTOMapper.toEntity(task);
        taskRepository.save(newTask);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}