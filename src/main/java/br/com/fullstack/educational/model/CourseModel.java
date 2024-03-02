package br.com.fullstack.educational.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Curso com métodos gerados pelo Lombok
 */
@Data
public class CourseModel {
    private static Integer nextId = 1;
    @Getter
    private static List<CourseModel> courses = new ArrayList<>();

    @Setter(AccessLevel.NONE)
    private Integer id;
    private String name;
    private String description;
    private Integer workload;

    private List<StudentModel> enrolledStudents = new ArrayList<>();

    private static Integer getNextId() {
        return nextId++;
    }

    public static CourseModel insert(CourseModel course) {
        course.id = getNextId();
        courses.add(course);
        return course;
    }

    public static CourseModel findById(Integer id) throws Exception {
        for (CourseModel course : courses) {
            if (course.getId().equals(id))
                return course;
        }
        throw new Exception("Curso não encontrado!");
    }

    public static void enroll(CourseModel course, StudentModel student) {
        course.getEnrolledStudents().add(student);
    }
}
