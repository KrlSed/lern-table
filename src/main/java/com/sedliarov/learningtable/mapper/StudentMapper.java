package com.sedliarov.learningtable.mapper;

import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student dtoToEntity(StudentDto studentDto);

    StudentDto entityToDto(Student student);
}
