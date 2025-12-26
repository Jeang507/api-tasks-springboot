package com.task.apitask.model;

import java.time.LocalDate;

/**
 * Clase modelo que representa una tarea dentro del sistema.
 * Contiene la información básica necesaria para su gestión.
 */
public class Task {

    /** Identificador único de la tarea */
    private Integer id;

    /** Título descriptivo de la tarea */
    private String title;

    /** Descripción detallada de la tarea */
    private String description;

    /** Estado actual de la tarea */
    private TaskStatus taskStatus;

    /** Nivel de prioridad de la tarea */
    private TaskPriority taskPriority;

    /** Fecha límite para completar la tarea */
    private LocalDate dueDate;

    /**
     * Constructor vacío.
     */
    public Task() {
    }

    /**
     * Constructor con todos los atributos de la tarea.
     *
     * @param id identificador de la tarea
     * @param title título de la tarea
     * @param description descripción de la tarea
     * @param taskStatus estado actual
     * @param taskPriority nivel de prioridad
     * @param dueDate fecha límite
     */
    public Task(Integer id, String title, String description, TaskStatus taskStatus,
                TaskPriority taskPriority, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
        this.dueDate = dueDate;
    }

    /**
     * Devuelve el identificador de la tarea.
     *
     * @return id de la tarea
     */
    public Integer getId() {
        return id;
    }

    /**
     * Asigna el identificador de la tarea.
     *
     * @param id identificador de la tarea
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Devuelve el título de la tarea.
     *
     * @return título
     */
    public String getTitle() {
        return title;
    }

    /**
     * Asigna el título de la tarea.
     *
     * @param title título de la tarea
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Devuelve la descripción de la tarea.
     *
     * @return descripción
     */
    public String getDescription() {
        return description;
    }

    /**
     * Asigna la descripción de la tarea.
     *
     * @param description descripción de la tarea
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Devuelve el estado actual de la tarea.
     *
     * @return estado de la tarea
     */
    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    /**
     * Asigna el estado de la tarea.
     *
     * @param taskStatus estado de la tarea
     */
    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * Devuelve la prioridad de la tarea.
     *
     * @return prioridad
     */
    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    /**
     * Asigna la prioridad de la tarea.
     *
     * @param taskPriority prioridad de la tarea
     */
    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    /**
     * Devuelve la fecha límite de la tarea.
     *
     * @return fecha límite
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Asigna la fecha límite de la tarea.
     *
     * @param dueDate fecha límite
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
