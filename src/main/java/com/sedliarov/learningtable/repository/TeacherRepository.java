package com.sedliarov.learningtable.repository;

import com.sedliarov.learningtable.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * This teacher repository interface extend default {@link JpaRepository} with entity teacher
 * and unique id.
 *
 * @author  Kirill Sedliarov
 */
public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}
