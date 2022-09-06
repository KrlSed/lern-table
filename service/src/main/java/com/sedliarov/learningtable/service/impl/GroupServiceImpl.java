package com.sedliarov.learningtable.service.impl;

import com.sedliarov.learningtable.mapper.GroupMapper;
import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.repository.GroupRepository;
import com.sedliarov.learningtable.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;

/**
 * Implementation for {@link GroupService}.
 *
 * @author Kirill Sedliarov
 */
@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

  private final GroupRepository repository;

  private final GroupMapper mapper;

  @Override
  public GroupDto createGroup(GroupDto groupDto) {
    Group groupToSave = mapper.dtoToEntity(groupDto);
    return mapper.entityToDto(repository.save(groupToSave));
  }

  @Override
  public GroupDto updateGroup(UUID id, GroupDto groupDto) {
    repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found with id " + id));

    Group groupToUpdate = mapper.dtoToEntity(groupDto);
    groupToUpdate.setGroupId(id);
    return mapper.entityToDto(repository.save(groupToUpdate));
  }

  @Override
  public void deleteGroup(UUID id) {
    repository.deleteById(id);
  }

  @Override
  public void deleteGroups() {
    repository.deleteAll();
  }

  @Override
  public GroupDto getGroupById(UUID id) {
    return mapper.entityToDto(repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Entity not found with id " + id)));
  }

  @Override
  public List<GroupDto> getGroups() {
    return repository.findAll().stream().map(mapper::entityToDto).toList();
  }
}
