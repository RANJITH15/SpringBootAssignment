package com.assign.onetomany.demo.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalityPOJO {
	

	private Integer locality;
	
	private String streetName;
	
	private String city;
	
	private List<WaterTankPOJO> waterTanks = new ArrayList<WaterTankPOJO>();

	
}
