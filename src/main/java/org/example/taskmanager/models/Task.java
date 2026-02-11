package org.example.taskmanager.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private String key;           // e.g. "PROJ-123"
    private String summary;       // e.g. "Fix login button not responding"
    private String description;
    private TaskType type;          // BUG, TASK, STORY
    private TaskStatus status;        // TODO, IN_PROGRESS, DONE
    private TaskPriority priority;      // LOW, MEDIUM, HIGH, CRITICAL
    private String assignee;

    public Task(String key, String summary, TaskType type, TaskStatus status, TaskPriority priority, String assignee) {
        this.key = key;
        this.summary = summary;
        this.type = type;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
    }

}