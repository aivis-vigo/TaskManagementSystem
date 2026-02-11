package org.example.taskmanager.dto;

import org.example.taskmanager.models.Task;
import org.springframework.stereotype.Service;

import java.util.function.Function;

// Function<Task, TaskDTO> - functional interface, when passed inside .map(taskDTOMapper) it automatically calls .apply() method

@Service
public class TaskDTOMapper implements Function<Task, TaskDTO> {

    public TaskDTO apply(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getKey(),
                task.getSummary(),
                task.getDescription(),
                task.getType(),
                task.getStatus(),
                task.getPriority(),
                task.getAssignee()
        );
    }

    public Task toEntity(CreateTaskDTO createTaskDTO) {
        return new Task(
                createTaskDTO.getKey(),
                createTaskDTO.getSummary(),
                createTaskDTO.getType(),
                createTaskDTO.getStatus(),
                createTaskDTO.getPriority(),
                createTaskDTO.getAssignee()
        );
    }

}
