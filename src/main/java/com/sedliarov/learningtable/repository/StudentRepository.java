package com.sedliarov.learningtable.repository;

import com.sedliarov.learningtable.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
}
