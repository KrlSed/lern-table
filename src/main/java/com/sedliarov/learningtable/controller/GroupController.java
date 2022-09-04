package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/groups")
public class GroupController {

  private final GroupService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GroupDto createGroup(@RequestBody GroupDto groupDto) {
    return service.createGroup(groupDto);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<GroupDto> getGroups() {
    return service.getGroups();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public GroupDto updateGroup(@PathVariable UUID id, @RequestBody GroupDto groupDto) {
    return service.updateGroup(id, groupDto);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public GroupDto getGroupById(@PathVariable UUID id) {
    return service.getGroupById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteGroup(@PathVariable UUID id) {
    service.deleteGroup(id);
  }
}
