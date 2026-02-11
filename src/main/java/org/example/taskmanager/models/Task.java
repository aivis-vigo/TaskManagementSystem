package org.example.taskmanager.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}