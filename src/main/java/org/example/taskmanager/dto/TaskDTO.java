package org.example.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.taskmanager.models.TaskPriority;
import org.example.taskmanager.models.TaskStatus;
import org.example.taskmanager.models.TaskType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Long id;
    @NotBlank(message = "Key is required")
    @Size(min = 3, max = 7, message = "Key must be between 3 and 7 characters")
    private String key;
    @NotBlank(message = "Summary is required")
    private String summary;
    private String description;
    private TaskType type;
    private TaskStatus status;
    private TaskPriority priority;
    private String assignee;

}
