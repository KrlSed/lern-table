package com.sedliarov.learningtable.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mapper configuration to load beans in moment init.
 *
 * @author  Kirill Sedliarov
 */
@Configuration
public class MapperConfiguration {

  @Bean
  public GroupMapper groupMapper() {
    return GroupMapper.INSTANCE;
  }

  @Bean
  public StudentMapper studentMapper() {
    return StudentMapper.INSTANCE;
  }

  @Bean
  public TeacherMapper teacherMapper() {
    return TeacherMapper.INSTANCE;
  }
}
