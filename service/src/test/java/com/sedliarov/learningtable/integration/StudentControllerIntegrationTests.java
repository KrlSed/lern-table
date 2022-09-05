package com.sedliarov.learningtable.integration;

import static org.assertj.core.api.Assertions.*;

import com.sedliarov.learningtable.mapper.StudentMapper;
import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.model.entity.Teacher;
import com.sedliarov.learningtable.repository.GroupRepository;
import com.sedliarov.learningtable.repository.StudentRepository;
import com.sedliarov.learningtable.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

public class StudentControllerIntegrationTests extends RestIntegrationTestBase{

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private GroupRepository groupRepository;

  @Autowired
  private TeacherRepository teacherRepository;

  private StudentMapper mapper = StudentMapper.INSTANCE;

  @Test
  void testGetStudentById() {
    // given
    Teacher newTeacher = new Teacher(null, "Regina", "Todarenco", false, null);
    Teacher savedTeacher = teacherRepository.save(newTeacher);
    Group newGroup = new Group(null,"12345", savedTeacher, null);
    Group savedGroup = groupRepository.save(newGroup);
    Student newStudent = new Student(null, "ReginaStud", "TodarencoStud", 10.2, savedGroup);
    Student savedStudent = studentRepository.save(newStudent);
    StudentDto studentMapper = mapper.entityToDto(newStudent);
    // when
    ResponseEntity<StudentDto> student = exchangeGetWithoutAuth("" + savedStudent.getStudentId(),
        StudentDto.class);
    // then
    assertThat(student.getBody()).isEqualTo(studentMapper);
  }
}
