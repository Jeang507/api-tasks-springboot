package com.task.apitask.mapper;

import com.task.apitask.dto.TaskRequestDTO;
import com.task.apitask.dto.TaskResponseDTO;
import com.task.apitask.model.Task;

public interface TaskMapper {

    Task toEntity(TaskRequestDTO dto);

    TaskResponseDTO toResponse(Task task);
}
