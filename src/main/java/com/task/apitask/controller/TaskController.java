package com.task.apitask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.task.apitask.model.Task;
import com.task.apitask.service.TaskService;

import java.net.URI;
import java.util.List;

/**
 * Controlador REST encargado de exponer los endpoints
 * para la gestión de tareas.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    /**
     * Constructor que inyecta el servicio de tareas.
     *
     * @param taskService servicio de gestión de tareas
     */
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Obtiene la lista completa de tareas.
     *
     * @return 200 OK con la lista de tareas
     */
    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    /**
     * Obtiene una tarea por su identificador.
     *
     * @param id identificador de la tarea
     * @return 200 OK con la tarea encontrada
     *         404 Not Found si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
        Task task = taskService.getTaskById(id);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    /**
     * Crea una nueva tarea.
     *
     * @param task datos de la tarea
     * @return 201 Created si se crea correctamente
     *         400 Bad Request si los datos no son válidos
     */
    @PostMapping
    public ResponseEntity<Task> postTask(@RequestBody Task task) {

        if (task == null) {
            return ResponseEntity.badRequest().build();
        }

        Task created = taskService.postTask(task);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

    /**
     * Actualiza completamente una tarea existente.
     *
     * @param id identificador de la tarea
     * @param task nuevos datos de la tarea
     * @return 200 OK si se actualiza correctamente
     *         404 Not Found si la tarea no existe
     *         400 Bad Request si los datos no son válidos
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> putTask(
            @PathVariable Integer id,
            @RequestBody Task task) {

        Task existing = taskService.getTaskById(id);

        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        if (task == null) {
            return ResponseEntity.badRequest().build();
        }

        Task updated = taskService.putTask(id, task);
        return ResponseEntity.ok(updated);
    }

    /**
     * Actualiza parcialmente una tarea existente.
     *
     * @param id identificador de la tarea
     * @param task campos a actualizar
     * @return 200 OK si se actualiza correctamente
     *         404 Not Found si la tarea no existe
     *         400 Bad Request si los datos no son válidos
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Task> patchTask(
            @PathVariable Integer id,
            @RequestBody Task task) {

        Task existing = taskService.getTaskById(id);

        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        if (task == null) {
            return ResponseEntity.badRequest().build();
        }

        Task updated = taskService.patchTask(id, task);
        return ResponseEntity.ok(updated);
    }

    /**
     * Elimina una tarea del sistema.
     *
     * @param id identificador de la tarea
     * @return 200 OK si se elimina correctamente
     *         404 Not Found si la tarea no existe
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Integer id) {

        Task removed = taskService.deleteTask(id);

        if (removed == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(removed);
    }
}
