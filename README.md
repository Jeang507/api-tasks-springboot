# Sistema Backend para Gestión de Tareas

Este proyecto es una API REST desarrollada con Spring Boot que permite gestionar tareas mediante operaciones CRUD.  
La idea principal es practicar el diseño de un backend bien estructurado, separando responsabilidades y usando correctamente los métodos HTTP.

---

## ¿De qué trata el proyecto?

En muchos casos, la gestión de tareas se hace de forma informal, lo que complica llevar control del estado, la prioridad o los plazos.  
Este proyecto busca resolver eso a nivel backend, ofreciendo endpoints claros para crear, consultar, actualizar y eliminar tareas.

No incluye interfaz gráfica ni base de datos, ya que el enfoque está en entender la lógica del backend y la arquitectura del sistema.

---

## ¿Qué se puede hacer con la API?

La API permite:

- Crear nuevas tareas
- Consultar todas las tareas registradas
- Obtener una tarea específica por su ID
- Actualizar una tarea completa (PUT)
- Actualizar solo algunos campos de una tarea (PATCH)
- Eliminar tareas

Cada tarea maneja información como título, descripción, estado, prioridad y fecha límite.

---

## Estructura del proyecto

El proyecto está organizado en capas para mantener el código claro y ordenado:

- **Controller**: recibe las peticiones HTTP y devuelve las respuestas.
- **Service**: define e implementa la lógica de negocio.
- **Model**: contiene la clase `Task` y sus enumeraciones.

Esta separación permite que el código sea más fácil de mantener y extender.

---

## Modelo de datos

La entidad principal es `Task`, que contiene:

- `id`
- `title`
- `description`
- `taskStatus` (PENDING, COMPLETED)
- `taskPriority` (LOW, MEDIUM, HIGH)
- `dueDate`

---

## Endpoints principales

- `GET /tasks` → devuelve todas las tareas
- `GET /tasks/{id}` → devuelve una tarea por ID
- `POST /tasks` → crea una nueva tarea
- `PUT /tasks/{id}` → actualiza una tarea completa
- `PATCH /tasks/{id}` → actualiza parcialmente una tarea
- `DELETE /tasks/{id}` → elimina una tarea

Las respuestas utilizan códigos HTTP adecuados como `200`, `201`, `400` y `404`.

---

## Tecnologías usadas

- Java
- Spring Boot
- Spring Web
- Gradle

---

## Ejecución del proyecto

Para ejecutar la aplicación:

```bash
./gradlew bootRun
```
En Windows:

gradlew bootRun

La API queda disponible en http://localhost:8080.

## Notas finales

Los datos se manejan únicamente en memoria y se inicializan al arrancar la aplicación.
El proyecto está pensado como una práctica de backend, enfocada en entender cómo funciona una API REST desde cero.

*** Autor ***
Proyecto desarrollado desde cero como práctica personal de desarrollo backend con Spring Boot.