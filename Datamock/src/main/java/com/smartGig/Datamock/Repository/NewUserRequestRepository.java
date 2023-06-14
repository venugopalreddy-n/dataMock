package com.smartGig.Datamock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartGig.Datamock.Models.NewUserRequest;

public interface NewUserRequestRepository extends JpaRepository<NewUserRequest,Integer> {

}
