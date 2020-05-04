package com.assign.onetomany.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assign.onetomany.demo.Entity.LocalityEntity;

public interface LocalityRep extends JpaRepository<LocalityEntity,Integer>{
	

}
