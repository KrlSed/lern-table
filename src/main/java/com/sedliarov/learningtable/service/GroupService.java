package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.model.dto.GroupDto;

import java.util.List;

public interface GroupService {

    GroupDto addGroup(GroupDto groupDto);

    GroupDto updateGroup(GroupDto groupDto);

    void deleteGroup(int id);

    GroupDto getGroupById(int id);

    List<GroupDto> getAllGroup();
}
