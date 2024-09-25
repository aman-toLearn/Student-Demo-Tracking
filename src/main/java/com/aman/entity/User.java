package com.aman.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Integer id;

    @Column(name = "USERNAME" , nullable = false)
    private String username;

    @Column(name = "PASSWORD" , nullable = false)
    private String password;


    @Column(name = "EMAIAL_ID", nullable = false)
    private String email;


    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles = new HashSet<>();

}
