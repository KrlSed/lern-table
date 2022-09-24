package com.sedliarov.learningtable.service.impl;

import com.github.dockerjava.api.exception.NotFoundException;
import com.sedliarov.learningtable.mapper.GroupMapper;
import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.model.enums.MessageCode;
import com.sedliarov.learningtable.repository.GroupRepository;
import com.sedliarov.learningtable.service.GroupService;
import com.sedliarov.learningtable.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

  private final MessageService messageService;

  @Override
  public GroupDto createGroup(GroupDto groupDto) {
    Optional<Group> group = repository.findByName(groupDto.getName());
    if (group.isPresent()) {
      throw new IllegalArgumentException(messageService.getMessage(MessageCode.ERROR_GROUP_ALREADY_EXIST,
          groupDto.getName()));
    }

    Group groupToSave = mapper.dtoToEntity(groupDto);
    return mapper.entityToDto(repository.save(groupToSave));
  }

  @Override
  public GroupDto updateGroup(UUID id, GroupDto groupDto) {
    repository.findById(id).orElseThrow(()
        -> new IllegalArgumentException(messageService.getMessage(MessageCode.ERROR_GROUP_NOT_FOUND, id)));
    Group groupToUpdate = mapper.dtoToEntity(groupDto);
    groupToUpdate.setGroupId(id);
    return mapper.entityToDto(repository.save(groupToUpdate));
  }

  @Override
  public void deleteGroup(UUID id) {
    repository.findById(id).orElseThrow(()
        -> new IllegalArgumentException(messageService.getMessage(MessageCode.ERROR_GROUP_NOT_FOUND, id)));
    repository.deleteById(id);
  }

  @Override
  public GroupDto getGroupById(UUID id) {
    return mapper.entityToDto(repository.findById(id).orElseThrow(()
        -> new NotFoundException(messageService.getMessage(MessageCode.ERROR_GROUP_NOT_FOUND, id))));
  }

  @Override
  public List<GroupDto> getGroups() {
    return repository.findAll().stream().map(mapper::entityToDto).toList();
  }
}
