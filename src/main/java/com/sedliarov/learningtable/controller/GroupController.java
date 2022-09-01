package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/groups")
public class GroupController {
    private final GroupService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDto addGroup(@RequestBody GroupDto groupDto) {
        return service.addGroup(groupDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDto> getGroups() {
        return service.getAllGroup();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return service.updateGroup(groupDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GroupDto getGroup(@PathVariable int id) {
        return service.getGroupById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteGroup(@PathVariable int id) {
        service.deleteGroup(id);
        return "Group " + id + " has been deleted";
    }

}
