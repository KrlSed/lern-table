package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        return service.createStudent(studentDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDto> getStudents() {
        return service.getStudents();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public StudentDto updateStudent(@PathVariable UUID id, @RequestBody StudentDto studentDto) {
        return service.updateStudent(id, studentDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDto getStudentById(@PathVariable UUID id) {
        return service.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable UUID id) {
        service.deleteStudent(id);
    }
}
