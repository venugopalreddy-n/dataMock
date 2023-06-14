package com.smartGig.Datamock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartGig.Datamock.Models.NewUser;
import com.smartGig.Datamock.Models.NewUserRequest;
import com.smartGig.Datamock.Models.OtpData;
import com.smartGig.Datamock.Repository.NewUserRequestRepository;
import com.smartGig.Datamock.Repository.OtpDataRepository;
import com.smartGig.Datamock.Service.NewUserServiceInterf;
import com.smartGig.Datamock.ServiceImpl.MailService;
import com.smartGig.Datamock.ServiceImpl.OtpService;

@RestController
public class NewUserController {

	@Autowired
	NewUserRequestRepository newUserRequestRepository;
	
	@Autowired
	OtpService otpService;
	
	@Autowired
	OtpDataRepository otpDataRepository;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	NewUserServiceInterf newUserServiceInterf;
	@PostMapping("/api/user")
	public ResponseEntity<String> createUser(@RequestBody NewUser user)
	{
	   	newUserServiceInterf.addUser(user);
	   	
	   	return new ResponseEntity("User Added Successfully",HttpStatus.CREATED);
	}
	@PostMapping("/register")
	public ResponseEntity<String> Register(@RequestBody NewUser user)
	{
		int otp =otpService.generateOtp();
		NewUserRequest newUser =    NewUserRequest.builder()
				                     .firstName(user.getFirstName())
				                     .lastName(user.getLastName())
				                     .contact(user.getContact())
				                     .password(user.getPassword())
				                     .email(user.getEmail()).build();
		OtpData otpData= new OtpData();
		otpData.setOtp(otp);
		otpData.setUser(newUser);
		
		newUserRequestRepository.save(newUser);
		otpService.addOtpData(otpData);
		
		mailService.SendMessage(user.getEmail(), otp);

		
		return new ResponseEntity("OTP send Successfully",HttpStatus.CREATED);
	}
	
}
