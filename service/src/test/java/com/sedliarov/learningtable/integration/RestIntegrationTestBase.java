package com.sedliarov.learningtable.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

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

  protected <T> ResponseEntity<T> exchangeGetWithoutAuth(String url, Class<T> responseType) {
    return testRestTemplate.getForEntity(url, responseType);
  }

  protected <T> ResponseEntity<T> exchangeAddWithoutAuth(String url, T entity, Class<T> responseType) {
    return testRestTemplate.postForEntity(url, entity, responseType);
  }

  protected <T> ResponseEntity<T> exchangeUpdateWithoutAuth(String url, T entity) {
    testRestTemplate.put(url, entity);
    return null;
  }

  protected <T> ResponseEntity<T> exchangeDeleteWithoutAuth(String url) {
    testRestTemplate.delete(url);
    return null;
  }
}
