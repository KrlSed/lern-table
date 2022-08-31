package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.dto.GroupDto;
import com.sedliarov.learningtable.model.Group;

import java.util.List;
import java.util.UUID;

public interface GroupService {

    GroupDto addGroup(GroupDto groupDto);

    GroupDto saveGroup(UUID id, GroupDto groupDto);

    void deleteGroup(UUID id);

    GroupDto getGroupById(UUID id);

    List<GroupDto> getAllGroup();

    List<GroupDto> sortedByNote();
}
