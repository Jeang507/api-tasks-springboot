package com.task.apitask.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.task.apitask.dto.TaskRequestDTO;
import com.task.apitask.dto.TaskResponseDTO;
import com.task.apitask.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<TaskResponseDTO> postTask(
            @RequestBody TaskRequestDTO dto) {

        TaskResponseDTO created = taskService.postTask(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(created);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> putTask(
            @PathVariable Integer id,
            @RequestBody TaskRequestDTO dto) {

        return ResponseEntity.ok(taskService.putTask(id, dto));
    }

    // PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> patchTask(
            @PathVariable Integer id,
            @RequestBody TaskRequestDTO dto) {

        return ResponseEntity.ok(taskService.patchTask(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> deleteTask(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }
}
