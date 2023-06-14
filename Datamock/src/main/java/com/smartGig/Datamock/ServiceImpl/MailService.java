package com.smartGig.Datamock.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	public void SendMessage(String to ,int otp)
	{
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		
		mailMessage.setFrom("venunrg@gmail.com");
		mailMessage.setTo(to);
		mailMessage.setSubject("Otp verification");
		mailMessage.setText("Verification of Mail and your OTP is "+otp);
		javaMailSender.send(mailMessage);
	}
}
