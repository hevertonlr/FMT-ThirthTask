package br.com.fullstack.educational.service;

import br.com.fullstack.educational.model.CourseModel;
import br.com.fullstack.educational.model.StudentModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CourseService {
    private final StudentService studentService;

    public CourseService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<CourseModel> listAll() {
        return CourseModel.getCourses();
    }

    public CourseModel findById(Integer id) throws Exception {
        return CourseModel.findById(id);
    }

    public CourseModel save(CourseModel course) throws Exception {
        if (!validate(course))
            return null;

        return CourseModel.insert(course);
    }

    public CourseModel enroll(Integer id, Integer studentId) throws Exception {
        CourseModel course = findById(id);
        StudentModel student = studentService.findById(studentId);
        CourseModel.enroll(course, student);
        return course;
    }

    private boolean validate(CourseModel course) throws Exception {
        if (!StringUtils.hasText(course.getName()))
            throw new Exception("Nome é obrigatório!");

        if (course.getWorkload() == null || course.getWorkload() <= 0)
            throw new Exception("Data de nascimento é obrigatório");

        return true;
    }
}
