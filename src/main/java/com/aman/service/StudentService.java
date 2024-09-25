package com.aman.service;


import com.aman.entity.Student;
import com.aman.exception.ResourceNotFoundException;
import com.aman.repositoty.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

     @Autowired
    private StudentRepository studentRepository;

    public Student saveStudentDemo(Student student){
        return studentRepository.save(student);


    }

    // Get a paginated list of students
    public List<Student> getAllStudents() {


        return studentRepository.findAll();
    }



    // Get students by name with pagination
    public Student getStudentsByName(String name ) {
        return studentRepository.findByName(name );
    }


    public Student updateStudent(Integer id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setYoutubeDemoLink(updatedStudent.getYoutubeDemoLink());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

}
