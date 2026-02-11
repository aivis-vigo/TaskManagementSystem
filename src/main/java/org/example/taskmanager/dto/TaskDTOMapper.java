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

    public Task toEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setKey(taskDTO.getKey());
        task.setSummary(taskDTO.getSummary());
        task.setDescription(taskDTO.getDescription());
        task.setType(taskDTO.getType());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        task.setAssignee(taskDTO.getAssignee());
        return task;
    }

}
