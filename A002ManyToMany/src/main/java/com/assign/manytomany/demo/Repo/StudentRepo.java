package com.assign.manytomany.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.assign.manytomany.demo.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer>{

}
