package com.task.apitask.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.task.apitask.dto.TaskRequestDTO;
import com.task.apitask.dto.TaskResponseDTO;
import com.task.apitask.error.ApiException;
import com.task.apitask.mapper.TaskMapper;
import com.task.apitask.model.Task;
import com.task.apitask.model.TaskPriority;
import com.task.apitask.model.TaskStatus;

@Service
public class TaskServiceImpl implements TaskService {

    private final List<Task> tasks = new ArrayList<>(Arrays.asList(
        new Task(1, "requerimientos del sistema",
            "Analizar la problemática y definir los requerimientos funcionales y no funcionales del sistema.",
            TaskStatus.COMPLETED, TaskPriority.HIGH, LocalDate.of(2025, 1, 5)),
        new Task(2, "Diseñar modelo de datos",
            "Definir la entidad Task y sus enumeraciones asociadas.",
            TaskStatus.COMPLETED, TaskPriority.HIGH, LocalDate.of(2025, 1, 7)),
        new Task(3, "Implementar capa de servicio",
            "Crear la interfaz TaskService y su implementación en memoria.",
            TaskStatus.PENDING, TaskPriority.MEDIUM, LocalDate.of(2025, 1, 10))
    ));

    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskResponseDTO> getTasks() {
        return tasks.stream()
                .map(taskMapper::toResponse)
                .toList();
    }

    @Override
    public TaskResponseDTO getTaskById(Integer id) {
        return taskMapper.toResponse(findTaskById(id));
    }

    @Override
    public TaskResponseDTO postTask(TaskRequestDTO dto) {
        Task task = taskMapper.toEntity(dto);
        task.setId(generateId());
        tasks.add(task);
        return taskMapper.toResponse(task);
    }

    @Override
    public TaskResponseDTO putTask(Integer id, TaskRequestDTO dto) {
        Task task = findTaskById(id);

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setTaskStatus(dto.getTaskStatus());
        task.setTaskPriority(dto.getTaskPriority());
        task.setDueDate(dto.getDueDate());

        return taskMapper.toResponse(task);
    }

    @Override
    public TaskResponseDTO patchTask(Integer id, TaskRequestDTO dto) {
        Task task = findTaskById(id);

        if (dto.getTitle() != null) {
            task.setTitle(dto.getTitle());
        }
        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }
        if (dto.getTaskStatus() != null) {
            task.setTaskStatus(dto.getTaskStatus());
        }
        if (dto.getTaskPriority() != null) {
            task.setTaskPriority(dto.getTaskPriority());
        }
        if (dto.getDueDate() != null) {
            task.setDueDate(dto.getDueDate());
        }

        return taskMapper.toResponse(task);
    }

    @Override
    public TaskResponseDTO deleteTask(Integer id) {
        Task task = findTaskById(id);
        tasks.remove(task);
        return taskMapper.toResponse(task);
    }

    private Task findTaskById(Integer id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ApiException(
                                "RESOURCE_NOT_FOUND",
                                "No existe una tarea con id " + id
                        ));
    }

    private Integer generateId() {
        return tasks.stream()
                .map(Task::getId)
                .max(Integer::compareTo)
                .orElse(0) + 1;
    }
}
