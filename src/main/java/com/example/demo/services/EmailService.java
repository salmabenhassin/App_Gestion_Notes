package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entities.EmailDetails;


@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
    @Value("${spring.mail.username}") private String sender;

	
	public String sendSimpleMail(EmailDetails email)
	{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(sender);
		mailMessage.setTo(email.getRecipient());
		mailMessage.setText(email.getMsgBody());
		mailMessage.setSubject(email.getSubject());
		javaMailSender.send(mailMessage);
		return "Mail sent successfully";
	}

}
