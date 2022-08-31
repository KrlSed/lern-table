package com.sedliarov.learningtable.repository;

import com.sedliarov.learningtable.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<Group, Integer> {

}
