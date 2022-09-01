package com.sedliarov.learningtable.service.impl;

import com.sedliarov.learningtable.mapper.StudentMapper;
import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.repository.StudentRepository;
import com.sedliarov.learningtable.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    private final StudentMapper mapper = StudentMapper.INSTANCE;

    @Override
    public StudentDto addStudent(StudentDto StudentDto) {
        try {
            Student dtoToStudent = mapper.dtoToStudent(StudentDto);
            Student student = repository.save(dtoToStudent);
            return mapper.studentToDto(student);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        return mapper.studentToDto(repository.findById(studentDto.getId()).map(student -> {
            student.setFirstName(studentDto.getFirstName());
            student.setSecondName(studentDto.getSecondName());
            student.setNote(studentDto.getNote());
            return repository.save(student);
        }).orElseGet(() -> {
            studentDto.setId(studentDto.getId());
            return repository.save(mapper.dtoToStudent(studentDto));
        }));
    }

    @Override
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    @Override
    public StudentDto getStudentById(int id) {
        return mapper.studentToDto(repository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> Students = (List<Student>) repository.findAll();
        return Students.stream().map(mapper::studentToDto).collect(Collectors.toList());
    }

}
