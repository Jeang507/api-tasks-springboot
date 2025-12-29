package com.task.apitask.mapper;

import org.springframework.stereotype.Component;
import com.task.apitask.dto.TaskRequestDTO;
import com.task.apitask.dto.TaskResponseDTO;
import com.task.apitask.model.Task;

@Component
public class TaskMapperImpl implements TaskMapper{

    @Override
    public Task toEntity(TaskRequestDTO dto){

        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setTaskStatus(dto.getTaskStatus());
        task.setTaskPriority(dto.getTaskPriority());
        task.setDueDate(dto.getDueDate());
        
        return task;

    }

    @Override
    public TaskResponseDTO toResponse(Task task){

        TaskResponseDTO taskResponseDTO = new TaskResponseDTO(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getTaskStatus(),
            task.getTaskPriority(),
            task.getDueDate()
        ); 

        return taskResponseDTO;
    }
}
