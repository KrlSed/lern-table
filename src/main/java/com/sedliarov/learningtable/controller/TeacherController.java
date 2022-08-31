package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private TeacherService service;

    @PostMapping
    public TeacherDto addTeacher(@RequestBody TeacherDto teacherDto) {
        return service.addTeacher(teacherDto);
    }

    @GetMapping
    public List<TeacherDto> getTeachers() {
        return service.getAllTeacher();
    }

    @PutMapping("/{id}")
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto) {
        return service.updateTeacher(teacherDto);
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacher(@PathVariable int id) {
        return service.getTeacherById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable int id) {
        service.deleteTeacher(id);
        return "Teacher " + id + " has been deleted";
    }
}

