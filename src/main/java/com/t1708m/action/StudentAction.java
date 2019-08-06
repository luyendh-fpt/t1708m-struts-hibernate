package com.t1708m.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.t1708m.entity.Student;
import com.t1708m.service.StudentService;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {

    private Student student;
    private StudentService studentService = new StudentService();

    public String create() {
        this.student = Student.Builder.aStudent().build();
        return INPUT;
    }

    public String store() {
        studentService.save(student);
        return SUCCESS;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Student getModel() {
        return student;
    }
}
