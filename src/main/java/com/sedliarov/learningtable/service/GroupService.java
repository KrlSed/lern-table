package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.model.dto.GroupDto;

import java.util.List;
import java.util.UUID;

public interface GroupService {

    GroupDto addGroup(GroupDto groupDto);

    GroupDto updateGroup(UUID id, GroupDto groupDto);

    void deleteGroup(UUID id);

    GroupDto getGroupById(UUID id);

    List<GroupDto> getAllGroup();
}
