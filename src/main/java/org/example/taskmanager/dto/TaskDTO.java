package org.example.taskmanager.dto;

import org.example.taskmanager.models.TaskPriority;
import org.example.taskmanager.models.TaskStatus;
import org.example.taskmanager.models.TaskType;

public class TaskDTO {

    private Long id;
    private String key;
    private String summary;
    private String description;
    private TaskType type;
    private TaskStatus status;
    private TaskPriority priority;
    private String assignee;

    public TaskDTO(Long id, String key, String summary, String description, TaskType type, TaskStatus status, TaskPriority priority, String assignee) {
        this.setId(id);
        this.setKey(key);
        this.setSummary(summary);
        this.setDescription(description);
        this.setType(type);
        this.setStatus(status);
        this.setPriority(priority);
        this.setAssignee(assignee);
    }

    public Long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public TaskType getType() {
        return type;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

}
