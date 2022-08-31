package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.dto.TeacherDto;
import com.sedliarov.learningtable.model.Teacher;
import com.sedliarov.learningtable.repository.TeacherRepository;
import com.sedliarov.learningtable.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository repository;

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher)
    {
        return repository.save(teacher);
    }

    @GetMapping()
    public List<Teacher> getTeachers() {return repository.findAll();}

    @PutMapping("/{id}")
    public Teacher updateTeacher(@RequestBody Teacher newTeacher, @PathVariable int id) {
        return repository.findById(id)
                .map(teacher -> {
                    teacher.setFirstName(newTeacher.getFirstName());
                    teacher.setSecondName(newTeacher.getSecondName());
                    teacher.setAdmin(newTeacher.isAdmin());
                    return repository.save(teacher);
                })
                .orElseGet(() -> {
                    newTeacher.setId(id);
                    return repository.save(newTeacher);
                });
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable int id) {return repository.findById(id).orElseThrow();}

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable int id) {
        repository.deleteById(id);
        return "Teacher has been deleted";
    }

}

