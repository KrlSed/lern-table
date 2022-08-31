package com.sedliarov.learningtable.controller;

import com.sedliarov.learningtable.model.Group;
import com.sedliarov.learningtable.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupRepository repository;

    @PostMapping
    public Group addGroup(@RequestBody Group group)
    {
        return repository.save(group);
    }

    @GetMapping()
    public List<Group> getGroups() {return repository.findAll();}


    @PutMapping("/{id}")
    public Group updateGroup(@RequestBody Group newGroup, @PathVariable int id) {
        return repository.findById(id)
                .map(group -> {
                    group.setName(newGroup.getName());
                    group.setTeacher(newGroup.getTeacher());
                    group.setStudentList(newGroup.getStudentList());
                    return repository.save(group);
                })
                .orElseGet(() -> {
                    newGroup.setId(id);
                    return repository.save(newGroup);
                });
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable int id) {return repository.findById(id).orElseThrow();}

    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable int id) {
        repository.deleteById(id);
        return "Group has been deleted";
    }
}
