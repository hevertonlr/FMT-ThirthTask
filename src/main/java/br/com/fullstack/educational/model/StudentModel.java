package br.com.fullstack.educational.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe Aluno com métodos gerados pelo Lombok
 */
@Getter
public class StudentModel {
    private static Integer nextId = 1;
    @Getter
    private static List<StudentModel> students = new ArrayList<>();

    @Getter
    private Integer id;
    @Setter
    private String name;
    @Setter
    private LocalDate birthDay;

    private static Integer getNextId() {
        return nextId++;
    }

    public static StudentModel insert(StudentModel student) {
        student.id = getNextId();
        students.add(student);
        return student;
    }

    public static StudentModel findById(Integer id) throws Exception {
        for (StudentModel student : students) {
            if (student.getId().equals(id))
                return student;
        }
        throw new Exception("Aluno não encontrado!");
    }
}

