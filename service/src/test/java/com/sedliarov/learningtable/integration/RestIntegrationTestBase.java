package com.sedliarov.learningtable.integration;

import com.sedliarov.learningtable.service.GroupService;
import com.sedliarov.learningtable.service.StudentService;
import com.sedliarov.learningtable.service.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;

/**
 * Main Rest template controller.
 *
 * @author Kirill Sedliarov
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RestIntegrationTestBase {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Autowired
  private StudentService studentService;

  @Autowired
  private GroupService groupService;

  @Autowired
  private TeacherService teacherService;

  @BeforeEach
  public void nullDataBase() {
    studentService.deleteStudents();
    teacherService.deleteTeachers();
    groupService.deleteGroups();
  }

  protected <T> ResponseEntity<T> exchangeGetWithoutAuth(String url, Class<T> responseType) {
    return testRestTemplate.getForEntity(url, responseType);
  }

  protected <T> ResponseEntity<T> exchangeAddWithoutAuth(String url, T entity, Class<T> responseType) {
    return testRestTemplate.postForEntity(url, entity, responseType);
  }

  protected <T> ResponseEntity<T> exchangeUpdateWithoutAuth(String url, T entity, Class<T> responseType) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<T> requestEntity = new HttpEntity<T>(entity, headers);
    return testRestTemplate.exchange(url, HttpMethod.PUT, requestEntity, responseType);
  }

  protected <T> ResponseEntity<T> exchangeDeleteWithoutAuth(String url, Class<T> responseType) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<T> requestEntity = new HttpEntity<T>(headers);
    return testRestTemplate.exchange(url, HttpMethod.DELETE, requestEntity, responseType);
  }
}
