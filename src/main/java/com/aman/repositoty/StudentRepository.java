package com.aman.repositoty;

import com.aman.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface StudentRepository extends JpaRepository<Student,Integer> {

   Student findByName(String name);
}
