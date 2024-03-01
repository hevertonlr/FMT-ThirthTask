package br.com.fullstack.educational.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe Curso com métodos gerados pelo Lombok
 */
@Getter
public class Course {
    @Getter private static Integer nextId = 1;

    @Getter private Integer id;
    @Setter private String name;
    @Setter private String description;
    @Setter private Integer workload;

}
