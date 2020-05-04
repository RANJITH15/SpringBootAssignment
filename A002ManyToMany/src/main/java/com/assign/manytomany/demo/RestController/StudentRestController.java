package com.assign.manytomany.demo.RestController;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assign.manytomany.demo.Service.StudentService;
import com.assign.manytomany.demo.pojo.StudentPOJO;

@RestController
public class StudentRestController {
	
	@Autowired
	private StudentService stdService;
	
	@RequestMapping(value="/getAllStudent",method =RequestMethod.GET)
	public Collection<StudentPOJO> getStudents(){
		
		return stdService.getStudents();
		
	}

}
