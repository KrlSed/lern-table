package com.sedliarov.learningtable.integration;

import com.sedliarov.learningtable.mapper.TeacherMapper;
import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.model.entity.Teacher;
import com.sedliarov.learningtable.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class TeacherControllerIntegrationTests extends RestIntegrationTestBase {

  @Autowired
  private TeacherRepository repository;

  private TeacherMapper mapper = TeacherMapper.INSTANCE;

  @Test
  void testGetTeacherById(){
    // given
    Teacher newTeacher = new Teacher(null, "Regina", "Todarenco", false, null);
    Teacher savedTeacher = repository.save(newTeacher);
    TeacherDto teacherMapper = mapper.entityToDto(newTeacher);
    // when
    ResponseEntity<TeacherDto> teacher =
        exchangeGetWithoutAuth("/teachers/" + savedTeacher.getTeacherId(),
            TeacherDto.class);
    // then
    assertThat(teacher.getBody()).isEqualTo(teacherMapper);
  }
}

