package com.example.demo.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {

	@NonNull
	private String to;
	private String subject;
}
