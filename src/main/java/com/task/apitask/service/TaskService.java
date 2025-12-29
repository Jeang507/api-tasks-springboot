package com.task.apitask.service;

import com.task.apitask.dto.TaskRequestDTO;
import com.task.apitask.dto.TaskResponseDTO;
import java.util.List;

public interface TaskService {

    List<TaskResponseDTO> getTasks();

    TaskResponseDTO getTaskById(Integer id);

    TaskResponseDTO postTask(TaskRequestDTO dto);

    TaskResponseDTO putTask(Integer id, TaskRequestDTO dto);

    TaskResponseDTO patchTask(Integer id, TaskRequestDTO dto);

    TaskResponseDTO deleteTask(Integer id);
}
