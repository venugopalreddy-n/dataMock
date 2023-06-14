package com.smartGig.Datamock.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OtpData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 private int otp;
	 @OneToOne
	 private NewUserRequest user;
	 
	
}
