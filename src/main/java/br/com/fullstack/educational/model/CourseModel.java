package br.com.fullstack.educational.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Curso com métodos gerados pelo Lombok
 */
@Getter
public class CourseModel {
    private static Integer nextId = 1;
    @Getter private static List<CourseModel> courses = new ArrayList<>();

    @Getter private Integer id;
    @Setter private String name;
    @Setter private String description;
    @Setter private Integer workload;

    private static Integer getNextId(){
        return nextId++;
    }

    public static CourseModel insert (CourseModel course){
        course.id = getNextId();
        courses.add(course);
        return course;
    }
}
