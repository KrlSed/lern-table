package com.sedliarov.learningtable.service.impl;

import com.sedliarov.learningtable.mapper.GroupMapper;
import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.repository.GroupRepository;
import com.sedliarov.learningtable.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;

    private final GroupMapper mapper = GroupMapper.INSTANCE;

    @Override
    public GroupDto addGroup(GroupDto groupDto) {
        Group groupToSave= mapper.dtoToEntity(groupDto);
        return mapper.entityToDto(repository.save(groupToSave));
    }

    @Override
    public GroupDto updateGroup(UUID id, GroupDto groupDto) {
        repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity not found with id " + id));

        Group groupToUpdate = mapper.dtoToEntity(groupDto);
        groupToUpdate.setId(id);
        return mapper.entityToDto(repository.save(groupToUpdate));
    }

    @Override
    public void deleteGroup(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public GroupDto getGroupById(UUID id) {
        return mapper.entityToDto(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<GroupDto> getAllGroup() {
        return repository.findAll().stream().map(mapper::entityToDto).toList();
    }

}
