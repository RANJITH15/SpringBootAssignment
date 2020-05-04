package com.assign.manytomany.demo.pojo;

import java.util.ArrayList;
import java.util.Collection;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentPOJO {
	
	
	private Integer id;
	private String studentName;
	private Collection<CoursePOJO> courseEntities = new ArrayList<CoursePOJO>();
	
}
