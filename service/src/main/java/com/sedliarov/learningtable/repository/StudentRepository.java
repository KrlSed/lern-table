package com.sedliarov.learningtable.repository;

import com.sedliarov.learningtable.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * This student repository interface extend default {@link JpaRepository} with entity student
 * and unique id.
 *
 * @author Kirill Sedliarov
 */
public interface StudentRepository extends JpaRepository<Student, UUID> {

  Optional<Student> findBySecondNameAndFirstName(String secondName, String firstName);
}
