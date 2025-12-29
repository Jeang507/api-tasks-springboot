# Task Management API – Spring Boot

API REST sencilla para la gestión de tareas, desarrollada con **Spring Boot**.  
El objetivo del proyecto es practicar una **arquitectura backend bien organizada**, usando DTOs, mappers y manejo centralizado de errores.

La aplicación trabaja **en memoria**, sin base de datos.

## ¿Qué hace esta API?

Permite:
- Crear tareas
- Listar todas las tareas
- Consultar una tarea por id
- Actualizar tareas (PUT y PATCH)
- Eliminar tareas

## Estructura del proyecto

El proyecto está organizado por capas:

controller → maneja las peticiones HTTP
service → lógica de negocio
dto → objetos de entrada y salida
mapper → conversión entre DTO y modelo
model → entidad Task y enums
error → excepciones personalizadas

Cada capa tiene una responsabilidad clara.

## Modelo Task

Una tarea contiene:
- id
- title
- description
- taskStatus (PENDING, COMPLETED)
- taskPriority (LOW, MEDIUM, HIGH)
- dueDate

## DTOs

- **TaskRequestDTO**  
  Se usa para recibir datos en POST, PUT y PATCH.  
  No incluye el id.

- **TaskResponseDTO**  
  Se usa para devolver datos al cliente.  
  Incluye el id y solo getters.


## Endpoints
```
| Método |       Ruta           | Descripción             |
|--------|----------------------|-------------------------|
| GET    | /api/v1/tasks        | Listar tareas           |
| GET    | /api/v1/tasks/{id}   | Obtener tarea por id    |
| POST   | /api/v1/tasks        | Crear tarea             |
| PUT    | /api/v1/tasks/{id}   | Reemplazar tarea        |
| PATCH  | /api/v1/tasks/{id}   | Actualizar parcialmente |
| DELETE | /api/v1/tasks/{id}   | Eliminar tarea          |
```

## Ejemplo de petición (POST)

```json
{
  "title": "Nueva tarea",
  "description": "Descripción de la tarea",
  "taskStatus": "PENDING",
  "taskPriority": "MEDIUM",
  "dueDate": "2025-01-15"
}

{
  "code": "RESOURCE_NOT_FOUND",
  "detail": "No existe una tarea con id 10"
}

Ejecutar el proyecto

Requisitos:

Java 17+

Gradle

Ejecutar:

./gradlew bootRun

La API queda disponible en:

http://localhost:8080/api/v1/tasks
