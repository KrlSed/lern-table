package com.sedliarov.learningtable.mapper;

import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.model.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for {@link TeacherDto} and {@link Teacher}.
 *
 * @author  Kirill Sedliarov
 */
@Mapper
public interface TeacherMapper {

  /**
   * Creating instance to teacher mapper
   */
  TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

  Teacher dtoToEntity(TeacherDto teacherDto);

  TeacherDto entityToDto(Teacher teacher);
}

