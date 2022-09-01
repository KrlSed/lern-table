package com.sedliarov.learningtable.service.impl;

import com.sedliarov.learningtable.mapper.TeacherMapper;
import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.model.entity.Teacher;
import com.sedliarov.learningtable.repository.TeacherRepository;
import com.sedliarov.learningtable.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;

    private final TeacherMapper mapper = TeacherMapper.INSTANCE;

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        try {
            Teacher dtoToTeacher = mapper.dtoToTeacher(teacherDto);
            Teacher teacher = repository.save(dtoToTeacher);
            return mapper.teacherToDto(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {
        return mapper.teacherToDto(repository.findById(teacherDto.getId()).map(teacher -> {
            teacher.setFirstName(teacherDto.getFirstName());
            teacher.setSecondName(teacherDto.getSecondName());
            teacher.setAdmin(teacherDto.isAdmin());
            return repository.save(teacher);
        }).orElseGet(() -> {
            teacherDto.setId(teacherDto.getId());
            return repository.save(mapper.dtoToTeacher(teacherDto));
        }));
    }

    @Override
    public void deleteTeacher(int id) {
        repository.deleteById(id);
    }

    @Override
    public TeacherDto getTeacherById(int id) {
        return mapper.teacherToDto(repository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public List<TeacherDto> getAllTeacher() {
        List<Teacher> teachers = (List<Teacher>) repository.findAll();
        return teachers.stream().map(mapper::teacherToDto).collect(Collectors.toList());
    }

}