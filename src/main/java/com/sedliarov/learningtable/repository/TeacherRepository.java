package com.sedliarov.learningtable.repository;

import com.sedliarov.learningtable.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
