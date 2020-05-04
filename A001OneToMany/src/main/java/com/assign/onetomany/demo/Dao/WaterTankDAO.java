package com.assign.onetomany.demo.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.assign.onetomany.demo.Entity.WaterTankEntity;
import com.assign.onetomany.demo.Repo.WaterTankRepo;
import com.assign.onetomany.demo.pojo.WaterTankPOJO;

@Repository
public class WaterTankDAO {
	
	@Autowired
	public WaterTankRepo wtRepo;
	public List<WaterTankPOJO> getWaterTank(){
		
		List<WaterTankEntity> wtEList=wtRepo.findAll();

		List<WaterTankPOJO> wtPojoList=new ArrayList<WaterTankPOJO>();
			
					for(WaterTankEntity wtEListOb : wtEList)
					{
						WaterTankPOJO wtPOJO=new WaterTankPOJO();
						wtPOJO.setCapacity(wtEListOb.getCapacity());
						wtPOJO.setWatertank(wtEListOb.getWatertank());
						wtPOJO.setLastCleanedDate(wtEListOb.getLastCleanedDate());
						wtPojoList.add(wtPOJO);
					}
			   
			
		 return wtPojoList;

	}
	
	
	
public List<WaterTankPOJO> saveWaterTank(WaterTankPOJO wtPojo){
	WaterTankEntity wtEntity=new WaterTankEntity();
	wtEntity.setCapacity(wtPojo.getCapacity());
	wtEntity.setLastCleanedDate(wtPojo.getLastCleanedDate());
	 wtRepo.save(wtEntity);
	
	   List<WaterTankEntity> wtEntityList=wtRepo.findAll();

	   List<WaterTankPOJO> wtPojoList=new ArrayList<WaterTankPOJO>();
		
				for(WaterTankEntity wtEntityListOb : wtEntityList)
				{
					WaterTankPOJO resWtPojo=new WaterTankPOJO();
					resWtPojo.setCapacity(wtEntityListOb.getCapacity());
					resWtPojo.setWatertank(wtEntityListOb.getWatertank());
					resWtPojo.setLastCleanedDate(wtEntityListOb.getLastCleanedDate());
					wtPojoList.add(resWtPojo);
				}
		   
		
	 return wtPojoList;
}


public List<WaterTankPOJO> updateWaterTank(Integer Id,WaterTankPOJO wtPojo){
	
Optional<WaterTankEntity> wtEntiy=wtRepo.findById(Id);
	
if(wtEntiy.isPresent()) {
	WaterTankEntity wtUpdateEntity=new WaterTankEntity();
	wtUpdateEntity.setWatertank(Id);
	wtUpdateEntity.setCapacity(wtPojo.getCapacity());
	wtUpdateEntity.setLastCleanedDate(wtPojo.getLastCleanedDate());
	 wtRepo.saveAndFlush(wtUpdateEntity);
	
}
	WaterTankEntity reswtEntity=wtRepo.findById(Id).get();

	WaterTankPOJO reswtPojo=new WaterTankPOJO();
	reswtPojo.setCapacity(reswtEntity.getCapacity());
	reswtPojo.setWatertank(reswtEntity.getWatertank());
	reswtPojo.setLastCleanedDate(reswtEntity.getLastCleanedDate());
				
	List<WaterTankPOJO> reswtPojoList=new ArrayList<WaterTankPOJO>();
	reswtPojoList.add(reswtPojo);
	 return reswtPojoList;
}	

public WaterTankPOJO deleteWaterTank(Integer Id){
	
	Optional<WaterTankEntity> wtEntity=wtRepo.findById(Id);
	
	if(wtEntity.isPresent()) {
		
		wtRepo.deleteById(Id);
		
	return new WaterTankPOJO(0,0,null);
	}else {
	
	return new WaterTankPOJO();
	}
	
	
}	


}
