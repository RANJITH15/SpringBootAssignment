package com.assign.manytomany.demo.Dao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.manytomany.demo.Repo.StudentRepo;
import com.assign.manytomany.demo.entity.CourseEntity;
import com.assign.manytomany.demo.entity.StudentEntity;
import com.assign.manytomany.demo.pojo.CoursePOJO;
import com.assign.manytomany.demo.pojo.StudentPOJO;
@Repository
public class StudentDao {

	@Autowired
	private StudentRepo stdRepo;
	
	public Collection<StudentPOJO> getStudents(){
		Collection<StudentEntity> stdEntityList=stdRepo.findAll();
		Collection<StudentPOJO>resStdPOJOList=new ArrayList<StudentPOJO>();
		for(StudentEntity stdEntityObj : stdEntityList) {
			StudentPOJO resStdPojo=new StudentPOJO();
			resStdPojo.setId(stdEntityObj.getId());
			resStdPojo.setStudentName(stdEntityObj.getStudentName());
			
			Collection<CourseEntity> crsEntityList=stdEntityObj.getCourseEntities();
			Collection<CoursePOJO> resCrsPojoList=new ArrayList<CoursePOJO>();
			for(CourseEntity crsEntityObj : crsEntityList) {
				CoursePOJO rescrsPojo=new CoursePOJO();
				rescrsPojo.setCourse_duration(crsEntityObj.getCourse_duration());
				rescrsPojo.setCourse_name(crsEntityObj.getCourse_name());
				rescrsPojo.setId(crsEntityObj.getId());
				resCrsPojoList.add(rescrsPojo);
			}
			resStdPojo.setCourseEntities(resCrsPojoList);
			resStdPOJOList.add(resStdPojo);
		}
		
		return resStdPOJOList;
		
	}
	
}
