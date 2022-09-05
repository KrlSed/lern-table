package com.sedliarov.learningtable.integration;

import com.sedliarov.learningtable.mapper.TeacherMapper;
import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.model.entity.Teacher;
import com.sedliarov.learningtable.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TeacherControllerIntegrationTests extends RestIntegrationTestBase {

  private static final String TEACHERS_URL = "/teachers/";
  @Autowired
  private TeacherRepository teacherRepository;

  // TODO: 9/5/2022 Need to create beans for all Mappers in Configuration class. And use @Autowired in tests.
  private TeacherMapper mapper = TeacherMapper.INSTANCE;

  @Test
  void testGetTeacherById() {
    // given
    // TODO: 9/5/2022 Need to implement Fixture{EntityName} static class and use in tests, like this case.
    Teacher newTeacher = new Teacher(null, "Regina", "Todarenco", false, null);
    Teacher savedTeacher = teacherRepository.save(newTeacher);
    TeacherDto teacherMapper = mapper.entityToDto(newTeacher);

    // when
    ResponseEntity<TeacherDto> teacher =
        exchangeGetWithoutAuth(TEACHERS_URL + savedTeacher.getTeacherId(), TeacherDto.class);

    // then
    assertThat(teacher.getBody()).isEqualTo(teacherMapper);
  }
}
