package com.assign.manytomany.demo.pojo;

import java.util.ArrayList;
import java.util.Collection;

import com.assign.manytomany.demo.entity.CourseEntity;
import com.assign.manytomany.demo.entity.StudentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursePOJO {
	private Integer id;
	private String course_name;
	private Integer course_duration;
	private Collection<StudentPOJO> studentEntities = new ArrayList<StudentPOJO>();
}
