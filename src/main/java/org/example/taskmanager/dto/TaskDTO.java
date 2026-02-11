package org.example.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.taskmanager.models.TaskPriority;
import org.example.taskmanager.models.TaskStatus;
import org.example.taskmanager.models.TaskType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Long id;
    private String key;
    private String summary;
    private String description;
    private TaskType type;
    private TaskStatus status;
    private TaskPriority priority;
    private String assignee;

}
