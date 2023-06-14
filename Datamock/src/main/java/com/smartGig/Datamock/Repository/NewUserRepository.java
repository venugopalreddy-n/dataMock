package com.smartGig.Datamock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartGig.Datamock.Models.NewUser;

public interface NewUserRepository  extends JpaRepository<NewUser,Integer>{
	

}
