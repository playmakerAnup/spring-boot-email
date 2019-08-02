package com.example.demo.service;

import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

	public void sendSimpleMessage(String to, String subject, String text);
	
	public void sendEmailWithAttachment(String to, String subject, String text, String attachmentPath);

}
