package com.smartGig.Datamock.ServiceImpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartGig.Datamock.Models.OtpData;
import com.smartGig.Datamock.Repository.NewUserRequestRepository;
import com.smartGig.Datamock.Repository.OtpDataRepository;


@Service
public class OtpService {
  @Autowired
  OtpDataRepository otpDataRepository;
  
  @Autowired
  NewUserRequestRepository newUserRequestRepository;
  
	public int generateOtp()
	{
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
	//	otpCache.put(key, otp);
		return otp;
		
	}
	public void addOtpData(OtpData data)
	{
		otpDataRepository.save(data);
	}
	public void deleteOtpData(int id)
	{ 
		OtpData data=otpDataRepository.findById(id).orElseThrow();
		int userid=data.getUser().getId();
		newUserRequestRepository.deleteById(userid);
		otpDataRepository.deleteById(id);
	}
	
}
