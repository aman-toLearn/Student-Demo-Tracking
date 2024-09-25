package com.aman.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(   name = "Student_name",nullable = false)
    private String name;

    @Column(name = "Student_Email",nullable = false)
    private String email;

    @Column( name = "Demo_Link",nullable = false)
    private String youtubeDemoLink;

    @Column(name = "CREATED_DATE", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE", updatable = true, insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;





}
