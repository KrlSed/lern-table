package com.sedliarov.learningtable.service.impl;

import com.sedliarov.learningtable.mapper.StudentMapper;
import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.repository.StudentRepository;
import com.sedliarov.learningtable.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;

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
    Student studentToCheck = repository.findBySecondName(studentToSave.getSecondName());
    if (studentToCheck != null) {
      throw new EntityAlreadyExistsException("Entity already exist");
    }
    return mapper.entityToDto(repository.save(studentToSave));
  }

  @Override
  public StudentDto updateStudent(UUID id, StudentDto studentDto) {
    repository.findById(id).orElseThrow(()
        -> new UpdateEntityNotFoundException("Entity for update not found"));
    Student studentToUpdate = mapper.dtoToEntity(studentDto);
    studentToUpdate.setStudentId(id);
    return mapper.entityToDto(repository.save(studentToUpdate));
  }

  @Override
  public void deleteStudent(UUID id) {
    repository.findById(id).orElseThrow(()
        -> new DeleteEntityNotFoundException("Entity not delete because not existed"));
    repository.deleteById(id);
  }

  @Override
  public StudentDto getStudentById(UUID id) {
    return mapper.entityToDto(repository.findById(id).orElseThrow(()
        -> new CustomEntityNotFoundException("Entity not found with id " + id)));
  }

  @Override
  public List<StudentDto> getStudents() {
    return repository.findAll().stream().map(mapper::entityToDto).toList();
  }

  /**
   * Exception for GET response if student not found.
   */
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public class CustomEntityNotFoundException extends EntityNotFoundException {

    public CustomEntityNotFoundException(String message) {
      super(message);
    }
  }

  /**
   * Exception for DELETE response if student not found.
   */
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public class DeleteEntityNotFoundException extends EntityNotFoundException {

    public DeleteEntityNotFoundException(String message) {
      super(message);
    }
  }

  /**
   * Exception for UPDATE response if student not found.
   */
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public class UpdateEntityNotFoundException extends EntityNotFoundException {

    public UpdateEntityNotFoundException(String message) {
      super(message);
    }
  }

  /**
   * Exception for POST response if student already exist.
   */
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public class EntityAlreadyExistsException extends HttpMessageNotWritableException {

    public EntityAlreadyExistsException(String message) {
      super(message);
    }
  }
}
