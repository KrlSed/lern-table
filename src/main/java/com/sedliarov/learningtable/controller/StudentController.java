package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService service;

    @PostMapping
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        return service.addStudent(studentDto);
    }

    @GetMapping
    public List<StudentDto> getStudents() {
        return service.getAllStudent();
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto) {
        return service.updateStudent(studentDto);
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student " + id + " has been deleted";
    }
}
