package com.aman.controller;


import com.aman.entity.Student;
import com.aman.service.EmailService;
import com.aman.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/studentsDemo")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmailService emailService;



    @PostMapping("/s")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){


        Student studentSubmitted = studentService.saveStudentDemo(student);

        emailService.sendDemoSubmissionMail(
                studentSubmitted.getEmail(),
                studentSubmitted.getName()
                ,studentSubmitted.getYoutubeDemoLink()
        );


        return ResponseEntity.ok("Your Demo Submitted and you got one mail for same !");
    }


    // Get all student demos with pagination
    @GetMapping("/getAll")
    public List<Student > getAllStudents()
             {
        return studentService.getAllStudents();
    }

    @GetMapping("/search")
    public Student getStudentsByName(
            @RequestParam String name)
             {
        return  studentService.getStudentsByName(name );
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

}
