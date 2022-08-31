package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.model.Student;
import com.sedliarov.learningtable.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository repository;

    @PostMapping
    public Student addStudent(@RequestBody Student student)
    {
        return repository.save(student);
    }

    @GetMapping()
    public List<Student> getStudents() {return repository.findAll();}

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable int id) {
        return repository.findById(id)
                .map(student -> {
                    student.setFirstName(newStudent.getFirstName());
                    student.setSecondName(newStudent.getSecondName());
                    student.setNote(newStudent.getNote());
                    return repository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return repository.save(newStudent);
                });
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {return repository.findById(id).orElseThrow();}

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        repository.deleteById(id);
        return "Student has been deleted";
    }
}
