package com.sedliarov.learningtable.service.impl;

import com.github.dockerjava.api.exception.NotFoundException;
import com.sedliarov.learningtable.mapper.StudentMapper;
import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.repository.StudentRepository;
import com.sedliarov.learningtable.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
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
    Student studentToSave = mapper.dtoToEntity(studentDto);
    boolean studentExist = repository.findBySecondNameAndFirstName(studentToSave.getSecondName(),
        studentToSave.getFirstName()).isPresent();
    if (studentExist) {
      throw new IllegalArgumentException("Entity already exist");
    }
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

  /**
   * Corrected basic handlers for api
   */
  @ControllerAdvice
  public class RestResponseEntityExceptionHandler
      extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
        = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleBadRequest(
        RuntimeException ex, WebRequest request) {
      Student bodyOfResponse = new Student();
      return handleExceptionInternal(ex, bodyOfResponse,
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(
        RuntimeException ex, WebRequest request) {
      Student bodyOfResponse = new Student();
      return handleExceptionInternal(ex, bodyOfResponse,
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
  }
}
