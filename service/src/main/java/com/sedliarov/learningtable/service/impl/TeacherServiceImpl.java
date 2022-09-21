package com.sedliarov.learningtable.service.impl;

import com.github.dockerjava.api.exception.NotFoundException;
import com.sedliarov.learningtable.mapper.TeacherMapper;
import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.model.entity.Teacher;
import com.sedliarov.learningtable.model.enums.MessageCode;
import com.sedliarov.learningtable.repository.TeacherRepository;
import com.sedliarov.learningtable.service.MessageService;
import com.sedliarov.learningtable.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation for {@link TeacherService}.
 *
 * @author Kirill Sedliarov
 */
@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

  private final TeacherRepository repository;

  private final TeacherMapper mapper;

  private final MessageService messageService;

  @Override
  public TeacherDto createTeacher(TeacherDto teacherDto) {
    Optional<Teacher> teacher = repository.findBySecondNameAndFirstName(teacherDto.getSecondName(),
        teacherDto.getFirstName());
    if (teacher.isPresent()) {
      throw new IllegalArgumentException(messageService.getMessage(MessageCode.ERROR_TEACHER_ALREADY_EXIST,
          teacherDto.getFirstName(), teacherDto.getSecondName()));
    }

    Teacher teacherToSave = mapper.dtoToEntity(teacherDto);
    return mapper.entityToDto(repository.save(teacherToSave));
  }

  @Override
  public TeacherDto updateTeacher(UUID id, TeacherDto teacherDto) {
    repository.findById(id).orElseThrow(()
        -> new IllegalArgumentException(messageService.getMessage(MessageCode.ERROR_TEACHER_NOT_FOUND, id)));
    Teacher teacherToUpdate = mapper.dtoToEntity(teacherDto);
    teacherToUpdate.setTeacherId(id);
    return mapper.entityToDto(repository.save(teacherToUpdate));
  }

  @Override
  public void deleteTeacher(UUID id) {
    repository.findById(id).orElseThrow(()
        -> new IllegalArgumentException(messageService.getMessage(MessageCode.ERROR_TEACHER_NOT_FOUND, id)));
    repository.deleteById(id);
  }

  @Override
  public TeacherDto getTeacherById(UUID id) {
    return mapper.entityToDto(repository.findById(id).orElseThrow(()
        -> new NotFoundException(messageService.getMessage(MessageCode.ERROR_TEACHER_NOT_FOUND, id))));
  }

  @Override
  public List<TeacherDto> getTeachers() {
    return repository.findAll().stream().map(mapper::entityToDto).toList();
  }
}
