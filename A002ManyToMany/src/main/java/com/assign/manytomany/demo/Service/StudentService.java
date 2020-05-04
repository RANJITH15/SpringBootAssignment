package com.assign.manytomany.demo.Service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.manytomany.demo.Dao.StudentDao;
import com.assign.manytomany.demo.pojo.StudentPOJO;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao stdDao;
	
	public Collection<StudentPOJO> getStudents(){
		
		return stdDao.getStudents();
		
	}

}
