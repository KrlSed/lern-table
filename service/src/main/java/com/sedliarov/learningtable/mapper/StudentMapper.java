package com.sedliarov.learningtable.mapper;

import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for {@link StudentDto} and {@link Student}.
 *
 * @author  Kirill Sedliarov
 */
@Mapper
public interface StudentMapper {

  /**
   * Creating instance to student mapper
   */
  StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

  Student dtoToEntity(StudentDto studentDto);

  StudentDto entityToDto(Student student);
}
