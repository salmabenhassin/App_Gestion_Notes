package com.example.demo.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EmailDonnes;
import com.example.demo.services.mailSeevDonImp;

@RestController
public class mailCDonnesontroller {

    @Autowired private mailSeevDonImp emailService;
 
    // Sending a simple Email
    @PostMapping(value = "/sendMail")
    public String sendMail(@RequestBody EmailDonnes details)
    {
        String status
            = emailService.sendMailtoetd(details);
 
        return status;
    }
 
}
