package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDto addTeacher(@RequestBody TeacherDto teacherDto) {
        return service.addTeacher(teacherDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherDto> getTeachers() {
        return service.getAllTeacher();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto) {
        return service.updateTeacher(teacherDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherDto getTeacher(@PathVariable int id) {
        return service.getTeacherById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteTeacher(@PathVariable int id) {
        service.deleteTeacher(id);
        return "Teacher " + id + " has been deleted";
    }
}

