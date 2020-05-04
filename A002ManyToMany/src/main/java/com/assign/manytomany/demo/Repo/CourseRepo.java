package com.assign.manytomany.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assign.manytomany.demo.entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer>{

}
