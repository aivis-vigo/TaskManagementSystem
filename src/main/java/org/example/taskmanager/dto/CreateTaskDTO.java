package org.example.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTaskDTO {

    @NotBlank(message = "Key is required")
    @Size(min = 3, max = 7, message = "Key must be between 3 and 7 characters")
    private String key;
    @NotBlank(message = "Summary is required")
    private String summary;
    private String description;
    @NotBlank(message = "Type is required")
    private String type;
    @NotBlank(message = "Priority is required")
    private String priority;
    private String assignee;

    public String getKey() { return key; }
    public String getSummary() { return summary; }
    public String getDescription() { return description; }
    public String getType() { return type; }
    public String getPriority() { return priority; }
    public String getAssignee() { return assignee; }

    public void setKey(String key) { this.key = key; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setDescription(String description) { this.description = description; }
    public void setType(String type) { this.type = type; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setAssignee(String assignee) { this.assignee = assignee; }

}
