package com.assign.onetomany.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.assign.onetomany.demo.Dao.WaterTankDAO;
import com.assign.onetomany.demo.pojo.WaterTankPOJO;

@Service
public class WaterTankService {
	
	
	@Autowired
	public WaterTankDAO waterTankDao;
	
	public List<WaterTankPOJO> saveWaterTank(WaterTankPOJO wtPojo){
		
		return  waterTankDao.saveWaterTank(wtPojo);
	}
	
	public List<WaterTankPOJO> getWaterTank(){
		
		return  waterTankDao.getWaterTank();
	}
	public List<WaterTankPOJO> updateWaterTank(Integer Id,WaterTankPOJO wtPojo){
		
		return  waterTankDao.updateWaterTank(Id,wtPojo);
	}	
	
	public WaterTankPOJO deleteWaterTank( Integer Id){
		
		return  waterTankDao.deleteWaterTank(Id);
	}	
	
}
