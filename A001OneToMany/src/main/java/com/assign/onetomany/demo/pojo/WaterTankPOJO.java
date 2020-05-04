package com.assign.onetomany.demo.pojo;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterTankPOJO {
	
	private Integer watertank;
	private Integer capacity;
	private Date lastCleanedDate;
}
