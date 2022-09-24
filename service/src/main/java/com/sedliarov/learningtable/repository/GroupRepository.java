package com.sedliarov.learningtable.repository;

import com.sedliarov.learningtable.model.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * This group repository interface extend default {@link JpaRepository} with entity group
 * and unique id.
 *
 * @author Kirill Sedliarov
 */
public interface GroupRepository extends JpaRepository<Group, UUID> {

  Optional<Group> findByName(String name);
}
