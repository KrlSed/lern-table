package com.sedliarov.learningtable.mapper;

import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.model.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher dtoToEntity(TeacherDto teacherDto);

    TeacherDto entityToDto(Teacher teacher);
}

