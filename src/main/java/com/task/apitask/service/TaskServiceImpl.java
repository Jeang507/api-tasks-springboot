package com.task.apitask.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.task.apitask.model.Task;
import com.task.apitask.model.TaskPriority;
import com.task.apitask.model.TaskStatus;

/**
 * Implementación en memoria del servicio de gestión de tareas.
 *
 * Esta clase maneja una lista de tareas inicializada al arrancar
 * la aplicación y aplica la lógica de negocio para las operaciones CRUD.
 */
@Service
public class TaskServiceImpl implements TaskService {

    /**
     * Lista de tareas almacenadas en memoria.
     */
    private List<Task> tasks = new ArrayList<>(Arrays.asList(
        new Task(1, "requerimientos del sistema",
            "Analizar la problemática y definir los requerimientos funcionales y no funcionales del sistema.",
            TaskStatus.COMPLETED, TaskPriority.HIGH, LocalDate.of(2025, 1, 5)),

        new Task(2, "Diseñar modelo de datos", "Definir la entidad Task y sus enumeraciones asociadas.",
            TaskStatus.COMPLETED, TaskPriority.HIGH, LocalDate.of(2025, 1, 7)),

        new Task(3, "Implementar capa de servicio", "Crear la interfaz TaskService y su implementación en memoria.",
            TaskStatus.PENDING, TaskPriority.MEDIUM, LocalDate.of(2025, 1, 10)),

        new Task(4, "Crear controlador REST", "Exponer los endpoints REST para la gestión de tareas.",
            TaskStatus.PENDING, TaskPriority.HIGH, LocalDate.of(2025, 1, 12)),

        new Task(5, "Cargar datos iniciales desde JSON",
            "Leer el archivo JSON ubicado en los recursos del proyecto para inicializar las tareas en memoria.",
            TaskStatus.PENDING, TaskPriority.MEDIUM, LocalDate.of(2025, 1, 14)),

        new Task(6, "Documentar la API", "Agregar documentación técnica y comentarios al código fuente.",
            TaskStatus.PENDING, TaskPriority.LOW, LocalDate.of(2025, 1, 18))
            
            ));

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task getTaskById(Integer id) {
        for (Task t : tasks) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task postTask(Task task) {
        tasks.add(task);
        return task;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task putTask(Integer id, Task task) {
        for (Task t : tasks) {
            if (t.getId().equals(id)) {
                t.setTitle(task.getTitle());
                t.setDescription(task.getDescription());
                t.setTaskStatus(task.getTaskStatus());
                t.setTaskPriority(task.getTaskPriority());
                t.setDueDate(task.getDueDate());
                return t;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task patchTask(Integer id, Task task) {
        for (Task t : tasks) {
            if (t.getId().equals(id)) {

                if (task.getTitle() != null) {
                    t.setTitle(task.getTitle());
                }
                if (task.getDescription() != null) {
                    t.setDescription(task.getDescription());
                }
                if (task.getTaskStatus() != null) {
                    t.setTaskStatus(task.getTaskStatus());
                }
                if (task.getTaskPriority() != null) {
                    t.setTaskPriority(task.getTaskPriority());
                }
                if (task.getDueDate() != null) {
                    t.setDueDate(task.getDueDate());
                }

                return t;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task deleteTask(Integer id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(id)) {
                Task removed = tasks.get(i);
                tasks.remove(removed);
                return removed;
            }
        }
        return null;
    }
}
