package com.sedliarov.learningtable.service.impl;

import com.sedliarov.learningtable.mapper.TeacherMapper;
import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.model.entity.Teacher;
import com.sedliarov.learningtable.repository.TeacherRepository;
import com.sedliarov.learningtable.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

  private final TeacherRepository repository;

  private final TeacherMapper mapper = TeacherMapper.INSTANCE;

  @Override
  public TeacherDto createTeacher(TeacherDto teacherDto) {
    Teacher teacherToSave = mapper.dtoToEntity(teacherDto);
    return mapper.entityToDto(repository.save(teacherToSave));
  }

  @Override
  public TeacherDto updateTeacher(UUID id, TeacherDto teacherDto) {
    repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found with id " + id));

    Teacher teacherToUpdate = mapper.dtoToEntity(teacherDto);
    teacherToUpdate.setTeacherId(id);
    return mapper.entityToDto(repository.save(teacherToUpdate));
  }

  @Override
  public void deleteTeacher(UUID id) {
    repository.deleteById(id);
  }

  @Override
  public TeacherDto getTeacherById(UUID id) {
    return mapper.entityToDto(repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Entity not found with id " + id)));
  }

  @Override
  public List<TeacherDto> getTeachers() {
    return repository.findAll().stream().map(mapper::entityToDto).toList();
  }
}