package com.sedliarov.learningtable.service.impl;

import com.sedliarov.learningtable.mapper.StudentMapper;
import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.repository.StudentRepository;
import com.sedliarov.learningtable.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    private final StudentMapper mapper = StudentMapper.INSTANCE;

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student studentToSave= mapper.dtoToEntity(studentDto);
        return mapper.entityToDto(repository.save(studentToSave));
    }

    @Override
    public StudentDto updateStudent(UUID id, StudentDto studentDto) {
        repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity not found with id " + id));

        Student studentToUpdate = mapper.dtoToEntity(studentDto);
        studentToUpdate.setId(id);
        return mapper.entityToDto(repository.save(studentToUpdate));
    }

    @Override
    public void deleteStudent(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public StudentDto getStudentById(UUID id) {
        return mapper.entityToDto(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<StudentDto> getAllStudent() {
        return repository.findAll().stream().map(mapper::entityToDto).toList();
    }

}
