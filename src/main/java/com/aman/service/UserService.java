package com.aman.service;

import com.aman.entity.User;
import com.aman.repositoty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

      @Autowired
      private UserRepository  userRepository;
      public User registerUser(User user){

           if (userRepository.findByUsername(user.getUsername()).isPresent()){

                throw  new IllegalStateException("Username already exist");
           }

//           user.setPassword(PasswordEncoder.encode(user.getPassword()));
             return  user;

    }


}
