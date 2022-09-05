package com.sedliarov.learningtable.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RestIntegrationTestBase {

  @Autowired
  private TestRestTemplate testRestTemplate;

  protected <T> ResponseEntity<T> exchangeGetWithoutAuth(String url, Class<T> responseType){
    return testRestTemplate.getForEntity(url, responseType);
  }
}