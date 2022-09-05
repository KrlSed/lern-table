package com.sedliarov.learningtable.integration;

import com.sedliarov.learningtable.mapper.GroupMapper;
import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.model.entity.Teacher;
import com.sedliarov.learningtable.repository.GroupRepository;
import com.sedliarov.learningtable.repository.StudentRepository;
import com.sedliarov.learningtable.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupControllerIntegrationTests extends RestIntegrationTestBase{
  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private GroupRepository groupRepository;

  @Autowired
  private TeacherRepository teacherRepository;

  private GroupMapper mapper = GroupMapper.INSTANCE;

  @Test
  void testGetGroupById(){
    // given
    //Teacher newTeacher = new Teacher(null, "Regina", "Todarenco", false, null);
    //Teacher savedTeacher = teacherRepository.save(newTeacher);
    //Student newStudent = new Student(null, "ReginaStud", "TodarencoStud", 10.2, null);
    //Student savedStudent = studentRepository.save(newStudent);
    //HashSet<Student> studentSet = new HashSet<Student>();
    //studentSet.add(savedStudent);
    Group newGroup = new Group(null, "111", null, null);
    Group savedGroup = groupRepository.save(newGroup);
    // when
    ResponseEntity<GroupDto> group =
        exchangeGetWithoutAuth("/groups/" + savedGroup.getGroupId(),
            GroupDto.class);
    GroupDto groupMapper = mapper.entityToDto(newGroup);
    // then
    assertThat(group.getBody()).isEqualTo(groupMapper);
  }
}
