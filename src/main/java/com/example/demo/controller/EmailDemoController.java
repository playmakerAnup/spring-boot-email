package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.request.EmailRequest;
import com.example.demo.response.EmailWithAttachmentResponse;
import com.example.demo.service.EmailService;
import com.example.demo.service.FileStorageService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/email")
@RestController
@Slf4j
public class EmailDemoController {

	@Autowired
	private EmailService emailService;

	@Autowired
	private FileStorageService fileStorageService;

	@PostMapping(value = "/send")
	public String sendEmail(@Valid EmailRequest emailRequest) {
		log.info("Sending Email Now...");
		emailService.sendSimpleMessage(emailRequest.getTo(), emailRequest.getSubject(), "The Chosen One");
		log.info("Email Sent Successfully...");
		return "Email Sent Successfully...";

	}

	@PostMapping(value = "/sendWithAttachment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public EmailWithAttachmentResponse sendEmailWithAttachment(@Valid EmailRequest emailRequest,
			@RequestParam("attachmentFile") MultipartFile attachmentFile) {
		log.info("Sending Mail with attachment");
		String filePath = fileStorageService.storeFile(attachmentFile);
		
		emailService.sendEmailWithAttachment(emailRequest.getTo(),
				emailRequest.getSubject(),
				"The Chosen One",
				filePath);
		log.info("Email Sent Successfully...");
		return new EmailWithAttachmentResponse(filePath.substring(filePath.lastIndexOf("\\")+1), filePath, attachmentFile.getContentType(),
				attachmentFile.getSize());

	}

}
