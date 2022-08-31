package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private GroupService service;

    @PostMapping
    public GroupDto addGroup(@RequestBody GroupDto groupDto) {
        return service.addGroup(groupDto);
    }

    @GetMapping
    public List<GroupDto> getGroups() {
        return service.getAllGroup();
    }

    @PutMapping("/{id}")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return service.updateGroup(groupDto);
    }

    @GetMapping("/{id}")
    public GroupDto getGroup(@PathVariable int id) {
        return service.getGroupById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable int id) {
        service.deleteGroup(id);
        return "Group " + id + " has been deleted";
    }
}
