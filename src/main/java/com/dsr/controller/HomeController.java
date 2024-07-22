package com.dsr.controller;

import java.time.LocalTime;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.m3support.demo.entity.email.SMTPMailSender;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class HomeController {
	
	
	//Method that sends an email notification to the user about submitting their daily status report.
//	@Autowired
//	private SMTPMailSender smtpMailSender;
	
	LocalTime alertTime = LocalTime.of(10,49);
	LocalTime alertTerminationTime = LocalTime.of(10,50);
//	@Scheduled(fixedRate = 40000)
//	public void ScheduledMailSender() throws MessagingException{
//
//		if(LocalTime.now().isAfter(alertTime) && LocalTime.now().isBefore(alertTerminationTime)) {
//
//			sendMail();
//			System.out.println("Email Reminder Has Been Sent.");
//		}
//	}
//

//	@RequestMapping("/send-mail")
//	public void sendMail() throws MessagingException {
//
//		smtpMailSender.send("mamellomitane01@outlook.com", "DSR Daily Notification", "Greetings Titan,please send your DSR to your reporting manager");
//
//	}
//
}

