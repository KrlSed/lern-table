package com.sedliarov.learningtable.service.impl;

import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.mapper.GroupMapper;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.repository.GroupRepository;
import com.sedliarov.learningtable.service.GroupService;

import java.util.List;
import java.util.stream.Collectors;

public class GroupServiceImpl implements GroupService {

    private GroupRepository repository;

    private GroupMapper mapper;

    @Override
    public GroupDto addGroup(GroupDto groupDto) {
        try {
            Group dtoToGroup = mapper.dtoToGroup(groupDto);
            Group group = repository.save(dtoToGroup);
            return mapper.groupToDto(group);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        return mapper.groupToDto(repository.findById(groupDto.getId()).map(group -> {
            group.setName(groupDto.getName());
            group.setTeacher(groupDto.getTeacher());
            group.setStudentList(groupDto.getStudentList());
            return repository.save(group);
        }).orElseGet(() -> {
            groupDto.setId(groupDto.getId());
            return repository.save(mapper.dtoToGroup(groupDto));
        }));
    }

    @Override
    public void deleteGroup(int id) {
        repository.deleteById(id);
    }

    @Override
    public GroupDto getGroupById(int id) {
        return mapper.groupToDto(repository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public List<GroupDto> getAllGroup() {
        List<Group> groups = (List<Group>) repository.findAll();
        return groups.stream().map(mapper::groupToDto).collect(Collectors.toList());
    }

}
