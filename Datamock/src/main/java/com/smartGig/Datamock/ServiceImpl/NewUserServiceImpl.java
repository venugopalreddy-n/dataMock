package com.smartGig.Datamock.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartGig.Datamock.Models.NewUser;
import com.smartGig.Datamock.Repository.NewUserRepository;
import com.smartGig.Datamock.Service.NewUserServiceInterf;

@Service
public class NewUserServiceImpl implements NewUserServiceInterf {

	@Autowired
	NewUserRepository newUserRepository;
	@Override
	public void addUser(NewUser user) {
		newUserRepository.save(user);
		
	}

	
}
