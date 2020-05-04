package com.assign.onetomany.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assign.onetomany.demo.Service.WaterTankService;
import com.assign.onetomany.demo.pojo.WaterTankPOJO;

@RestController
public class WaterTankController {

	@Autowired
	public WaterTankService waterService;
	
	@RequestMapping(value="/saveWaterTank", method = RequestMethod.POST)
	public List<WaterTankPOJO> saveWaterTank(@RequestBody WaterTankPOJO wtPojo){
		
		return  waterService.saveWaterTank(wtPojo);
	}
	
	@RequestMapping(value="/getWaterTank", method = RequestMethod.GET)
	public List<WaterTankPOJO> getWaterTank(){
		
		return  waterService.getWaterTank();
	}
	
	@RequestMapping(value="/updateWaterTank/{Id}",method=RequestMethod.PUT)
	public List<WaterTankPOJO> updateWaterTank(@PathVariable Integer Id,@RequestBody WaterTankPOJO wtPojo){
		
		return  waterService.updateWaterTank(Id,wtPojo);
	}	
	
	@RequestMapping(value="/deleteWaterTank/{Id}",method=RequestMethod.DELETE)
	public WaterTankPOJO deleteWaterTank(@PathVariable Integer Id){
		
		return  waterService.deleteWaterTank(Id);
	}	
	
}
