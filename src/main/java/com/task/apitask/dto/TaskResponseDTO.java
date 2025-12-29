package com.task.apitask.dto;
import com.task.apitask.model.*;
import java.time.LocalDate;

public class TaskResponseDTO {

    private Integer id;

    private String title;

    private String description;

    private TaskStatus taskStatus;

    private TaskPriority taskPriority;

    private LocalDate dueDate;

    public TaskResponseDTO(Integer id, String title, String description, 
    TaskStatus taskStatus, TaskPriority taskPriority, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    
    
}
