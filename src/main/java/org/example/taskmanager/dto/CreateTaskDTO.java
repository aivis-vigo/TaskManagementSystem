package org.example.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.taskmanager.models.TaskPriority;
import org.example.taskmanager.models.TaskStatus;
import org.example.taskmanager.models.TaskType;

@Getter
@Setter
public class CreateTaskDTO {

    @NotBlank(message = "Key is required")
    @Size(min = 3, max = 7, message = "Key must be between 3 and 7 characters")
    private String key;
    @NotBlank(message = "Summary is required")
    private String summary;
    private String description;
    @NotNull(message = "Type is required")
    private TaskType type;
    @NotNull(message = "Status is required")
    private TaskStatus status;
    @NotNull(message = "Priority is required")
    private TaskPriority priority;
    private String assignee;

}
