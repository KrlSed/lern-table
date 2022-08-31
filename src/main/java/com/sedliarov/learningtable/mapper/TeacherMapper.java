package com.sedliarov.learningtable.mapper;

import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.model.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(source = "role", target = "role")
    Teacher dtoToTeacher(TeacherDto teacherDto);

    @Mapping(source = "role", target = "role")
    TeacherDto teacherToDto(Teacher teacher);
}

