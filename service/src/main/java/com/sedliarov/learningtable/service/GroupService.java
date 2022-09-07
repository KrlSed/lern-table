package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.model.dto.GroupDto;

import java.util.List;
import java.util.UUID;

/**
 * Group service with necessary REST api methods.
 *
 * @author  Kirill Sedliarov
 */
public interface GroupService {

  GroupDto createGroup(GroupDto groupDto);

  GroupDto updateGroup(UUID id, GroupDto groupDto);

  void deleteGroup(UUID id);

  GroupDto getGroupById(UUID id);

  List<GroupDto> getGroups();
}
