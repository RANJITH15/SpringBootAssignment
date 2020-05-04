package com.assign.onetomany.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assign.onetomany.demo.Entity.WaterTankEntity;

public interface WaterTankRepo extends JpaRepository<WaterTankEntity, Integer> {

}
