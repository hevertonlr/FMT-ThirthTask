package br.com.fullstack.educational.controller;

import br.com.fullstack.educational.model.StudentModel;
import br.com.fullstack.educational.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentModel> get() {
        return studentService.listAll();
    }

    @PostMapping
    public StudentModel post(@RequestBody StudentModel student) throws Exception {
        return studentService.save(student);
    }
}
