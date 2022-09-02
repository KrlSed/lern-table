package com.sedliarov.learningtable.repository;

import com.sedliarov.learningtable.model.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface GroupRepository extends JpaRepository<Group, UUID>{
    Optional<Group> findById(UUID id);
}
