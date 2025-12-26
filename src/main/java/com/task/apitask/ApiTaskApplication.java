package com.task.apitask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación.
 *
 * Contiene el método main que arranca la aplicación
 * Spring Boot y configura el contexto inicial.
 */
@SpringBootApplication
public class ApiTaskApplication {

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiTaskApplication.class, args);
    }
}
