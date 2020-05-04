package com.assign.onetomany.demo.RestController;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assign.onetomany.demo.Service.LocalityService;
import com.assign.onetomany.demo.pojo.LocalityPOJO;
import com.assign.onetomany.demo.pojo.WaterTankPOJO;


@RestController
public class LocalityController {
	
	
	public LocalityController() {
		super();
		// TODO Auto-generated constructor stub
		//LocalityPOJO ls =new LocalityPOJO(1,"lll","sdsd");
		
		//hi
	}

	@Autowired
	private LocalityService lservice;
	
	@RequestMapping(value = "/check")
	private String Welcome()
	{
		return lservice.getWelcome();
	}

	@RequestMapping(value="/allLocality",method=RequestMethod.GET)
	public List <LocalityPOJO> getAllLocality() {	
		return lservice.getAllLocality();
	}
	
	@RequestMapping(value ="/saveLocality" , method = RequestMethod.POST)
	public List <LocalityPOJO> saveLocality(@RequestBody LocalityPOJO locality)
	{
		return  lservice.saveLocality(locality);
	}
	
	@RequestMapping(value ="/updateLocality/{Id}" , method = RequestMethod.PUT)
	public List <LocalityPOJO> updateLocality(@PathVariable Integer Id,@RequestBody LocalityPOJO locality)
	{
		return  lservice.updateLocality(Id,locality);
	}
	
	@RequestMapping(value ="/deleteLocality/{Id}" , method = RequestMethod.DELETE)
	public String deleteLocality(@PathVariable Integer Id)
	{
		return  lservice.deleteLocality(Id);
	}
}
