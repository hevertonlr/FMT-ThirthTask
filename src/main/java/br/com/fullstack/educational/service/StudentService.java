package br.com.fullstack.educational.service;

import br.com.fullstack.educational.model.CourseModel;
import br.com.fullstack.educational.model.StudentModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentService {

    public List<StudentModel> listAll() {
        return StudentModel.getStudents();
    }

    public StudentModel findById(Integer id) throws Exception {
        return StudentModel.findById(id);
    }

    public StudentModel save(StudentModel student) throws Exception {
        if (!validate(student))
            return null;

        return StudentModel.insert(student);
    }

    private boolean validate(StudentModel student) throws Exception {
        if (!StringUtils.hasText(student.getName()))
            throw new Exception("Nome é obrigatório!");

        if (student.getBirthDay() == null)
            throw new Exception("Carga horária é obrigatório");

        return true;
    }
}
