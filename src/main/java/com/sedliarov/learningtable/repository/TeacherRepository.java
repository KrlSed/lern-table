package com.sedliarov.learningtable.repository;

import com.sedliarov.learningtable.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}
