package com.sedliarov.learningtable.mapper;

import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "role", target = "role")
    Student dtoToStudent(StudentDto studentDto);

    @Mapping(source = "role", target = "role")
    StudentDto studentToDto(Student student);
}
