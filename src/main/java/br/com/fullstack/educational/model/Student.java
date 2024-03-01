package br.com.fullstack.educational.model;

import lombok.*;

import java.util.Date;

/**
 * Classe Aluno com métodos gerados pelo Lombok
 */
@Getter
public class Student {
    @Getter private static Integer nextId = 1;

    @Getter private Integer id;
    @Setter private String name;
    @Setter private Date birthDay;
}

