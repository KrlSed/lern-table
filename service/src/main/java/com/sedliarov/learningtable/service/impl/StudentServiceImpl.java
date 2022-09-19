package com.sedliarov.learningtable.service.impl;

import com.github.dockerjava.api.exception.NotFoundException;
import com.sedliarov.learningtable.mapper.StudentMapper;
import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.repository.StudentRepository;
import com.sedliarov.learningtable.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation for {@link StudentService}.
 *
 * @author Kirill Sedliarov
 */
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository repository;

  private final StudentMapper mapper;

  @Override
  public StudentDto createStudent(StudentDto studentDto) {
    Optional<Student> student = repository.findBySecondNameAndFirstName(studentDto.getSecondName(),
        studentDto.getFirstName());
    if (student.isPresent()) {
      throw new IllegalArgumentException("Entity already exist");
    }

    Student studentToSave = mapper.dtoToEntity(studentDto);
    return mapper.entityToDto(repository.save(studentToSave));
  }

  @Override
  public StudentDto updateStudent(UUID id, StudentDto studentDto) {
    repository.findById(id).orElseThrow(()
        -> new IllegalArgumentException("Entity for update not found"));
    Student studentToUpdate = mapper.dtoToEntity(studentDto);
    studentToUpdate.setStudentId(id);
    return mapper.entityToDto(repository.save(studentToUpdate));
  }

  @Override
  public void deleteStudent(UUID id) {
    repository.findById(id).orElseThrow(()
        -> new IllegalArgumentException("Entity not delete because not existed"));
    repository.deleteById(id);
  }

  @Override
  public StudentDto getStudentById(UUID id) {
    return mapper.entityToDto(repository.findById(id).orElseThrow(()
        -> new NotFoundException("Entity not found with id " + id)));
  }

  @Override
  public List<StudentDto> getStudents() {
    return repository.findAll().stream().map(mapper::entityToDto).toList();
  }


}
