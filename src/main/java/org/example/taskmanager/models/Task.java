package org.example.taskmanager.models;

public class Task {
    private Long id;
    private String key;           // e.g. "PROJ-123"
    private String summary;       // e.g. "Fix login button not responding"
    private String description;
    private String type;          // BUG, TASK, STORY
    private String status;        // TODO, IN_PROGRESS, DONE
    private String priority;      // LOW, MEDIUM, HIGH, CRITICAL
    private String assignee;

    public Task(String key, String summary, String type, String status, String priority, String assignee) {
        this.key = key;
        this.summary = summary;
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

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getAssignee() { return assignee; }
    public void setAssignee(String assignee) { this.assignee = assignee; }
}