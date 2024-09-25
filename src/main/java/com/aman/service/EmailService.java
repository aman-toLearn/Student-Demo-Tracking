package com.aman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;


@Service
public class EmailService {
    @Autowired
private JavaMailSender sender;

    public void sendDemoSubmissionMail(String toEmail, String studentName,String demoLink){

        String subject = "Demo Submission Successful";

        String body = "Dear " + studentName + ",\n\n" +
                "Your demo submission has been received successfully. Here are the details:\n" +
                "Student Name: " + studentName + "\n" +
                "Demo Link: " + demoLink + "\n\n" +
                "Thank you for your submission!\n\n" +
                "Best regards,\n Aman";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("amanb7ambivert@gmail.com");  // Replace with your sender email
        message.setTo(toEmail);                  // Recipient email
        message.setSubject(subject);
        message.setText(body);


        sender.send(message);



    }



}
