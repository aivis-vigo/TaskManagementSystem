package org.example.taskmanager.models;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "task_key")
    private String key;           // e.g. "PROJ-123"
    private String summary;       // e.g. "Fix login button not responding"
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskType type;          // BUG, TASK, STORY
    @Enumerated(EnumType.STRING)
    private TaskStatus status;        // TODO, IN_PROGRESS, DONE
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;      // LOW, MEDIUM, HIGH, CRITICAL
    private String assignee;

    public Task(String key, String summary, String description, TaskType type, TaskStatus status, TaskPriority priority, String assignee) {
        this.key = key;
        this.summary = summary;
        this.description = description;
        this.type = type;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public String getAssignee() { return assignee; }
    public void setAssignee(String assignee) { this.assignee = assignee; }
}