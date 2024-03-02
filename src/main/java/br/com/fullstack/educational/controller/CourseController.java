package br.com.fullstack.educational.controller;

import br.com.fullstack.educational.model.CourseModel;
import br.com.fullstack.educational.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseModel> get() {
        return courseService.listAll();
    }

    @PostMapping
    public CourseModel post(@RequestBody CourseModel course) throws Exception {
        return courseService.save(course);
    }

    @PostMapping("{id}/matricular")
    public CourseModel post(@PathVariable Integer id, @RequestBody CourseModel course) throws Exception {
        return courseService.enroll(id, course.getId());
    }
}
