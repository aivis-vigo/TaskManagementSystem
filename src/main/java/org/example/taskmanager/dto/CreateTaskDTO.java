package org.example.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.taskmanager.models.TaskPriority;
import org.example.taskmanager.models.TaskStatus;
import org.example.taskmanager.models.TaskType;

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

    public String getKey() { return key; }
    public String getSummary() { return summary; }
    public String getDescription() { return description; }
    public TaskType getType() { return type; }
    public TaskStatus getStatus() { return status; }
    public TaskPriority getPriority() { return priority; }
    public String getAssignee() { return assignee; }

    public void setKey(String key) { this.key = key; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setDescription(String description) { this.description = description; }
    public void setType(TaskType type) { this.type = type; }
    public void setStatus(TaskStatus status) { this.status = status; }
    public void setPriority(TaskPriority priority) { this.priority = priority; }
    public void setAssignee(String assignee) { this.assignee = assignee; }

}
