package org.example.taskmanager.controllers;

import jakarta.validation.Valid;
import org.example.taskmanager.dto.CreateTaskDTO;
import org.example.taskmanager.dto.TaskDTO;
import org.example.taskmanager.models.Task;
import org.example.taskmanager.models.TaskPriority;
import org.example.taskmanager.models.TaskStatus;
import org.example.taskmanager.models.TaskType;
import org.example.taskmanager.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks/list";
    }

    @GetMapping("/{id}")
    public String viewTaskById(@PathVariable Long id, Model model) {
        try {
            TaskDTO task = taskService.getTaskById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + id));
            model.addAttribute("task", task);
            return "tasks/view";
        } catch (IllegalArgumentException e) {
            return "redirect:/error/404";
        }
    }

    @GetMapping("/create/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new CreateTaskDTO());
        model.addAttribute("types", TaskType.values());
        model.addAttribute("statuses", TaskStatus.values());
        model.addAttribute("priorities", TaskPriority.values());
        return "tasks/create";
    }

    @PostMapping("/create")
    public String createTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("types", TaskType.values());
            model.addAttribute("statuses", TaskStatus.values());
            model.addAttribute("priorities", TaskPriority.values());
            return "tasks/create";
        }
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            TaskDTO task = taskService.getTaskById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + id));
            model.addAttribute("task", task);
            return "tasks/edit";
        } catch (IllegalArgumentException e) {
            return "redirect:/error/404";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute TaskDTO task) {
        task.setId(id);
        taskService.updateTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}