package br.com.fullstack.educational.service;

import br.com.fullstack.educational.model.CourseModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CourseService {
    public List<CourseModel> listAll(){
        return CourseModel.getCourses();
    }
    public CourseModel save(CourseModel course) throws Exception{
        if(!validate(course))
            return null;

        return CourseModel.insert(course);
    }

    private boolean validate(CourseModel course) throws Exception{
        if(!StringUtils.hasText(course.getName()))
            throw new Exception("Nome é obrigatório!");

        if(course.getWorkload() == null || course.getWorkload() <= 0)
            throw new Exception("Data de nascimento é obrigatório");

        return true;
    }
}
