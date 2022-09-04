package com.sedliarov.learningtable.repository;

import com.sedliarov.learningtable.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
