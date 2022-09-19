package com.sedliarov.learningtable.integration;

import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class StudentControllerIntegrationTest extends RestIntegrationTestBase{

  @Autowired
  private StudentRepository repository;

  @Test
  void testGetStudentById(){
    // given

    // when
    ResponseEntity<StudentDto> student = exchangeGetWithoutAuth("", StudentDto.class);

    // then

  }
}
