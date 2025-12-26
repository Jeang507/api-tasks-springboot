package com.task.apitask.service;

import com.task.apitask.model.Task;
import java.util.List;

/**
 * Interfaz que define las operaciones disponibles
 * para la gestión de tareas.
 */
public interface TaskService {

    /**
     * Obtiene la lista completa de tareas registradas.
     *
     * @return lista de tareas
     */
    List<Task> getTasks();

    /**
     * Busca una tarea por su identificador.
     *
     * @param id identificador de la tarea
     * @return tarea encontrada o null si no existe
     */
    Task getTaskById(Integer id);

    /**
     * Registra una nueva tarea.
     *
     * @param task tarea a crear
     * @return tarea creada
     */
    Task postTask(Task task);

    /**
     * Actualiza completamente una tarea existente.
     *
     * @param id identificador de la tarea
     * @param task datos nuevos de la tarea
     * @return tarea actualizada o null si no existe
     */
    Task putTask(Integer id, Task task);

    /**
     * Actualiza parcialmente una tarea existente.
     *
     * @param id identificador de la tarea
     * @param task campos a actualizar
     * @return tarea actualizada o null si no existe
     */
    Task patchTask(Integer id, Task task);

    /**
     * Elimina una tarea del sistema.
     *
     * @param id identificador de la tarea
     * @return tarea eliminada o null si no existe
     */
    Task deleteTask(Integer id);
}
