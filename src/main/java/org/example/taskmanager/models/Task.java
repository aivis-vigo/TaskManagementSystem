package org.example.taskmanager.models;

public class Task {
    private Long id;
    private String key;           // e.g. "PROJ-123"
    private String summary;       // e.g. "Fix login button not responding"
    private String description;
    private TaskType type;          // BUG, TASK, STORY
    private TaskStatus status;        // TODO, IN_PROGRESS, DONE
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

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public String getAssignee() { return assignee; }
    public void setAssignee(String assignee) { this.assignee = assignee; }
}