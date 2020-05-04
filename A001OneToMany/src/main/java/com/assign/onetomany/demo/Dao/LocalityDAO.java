package com.assign.onetomany.demo.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.onetomany.demo.Entity.LocalityEntity;
import com.assign.onetomany.demo.Entity.WaterTankEntity;
import com.assign.onetomany.demo.Repo.LocalityRep;
import com.assign.onetomany.demo.Repo.WaterTankRepo;
import com.assign.onetomany.demo.pojo.LocalityPOJO;
import com.assign.onetomany.demo.pojo.WaterTankPOJO;

@Repository
public class LocalityDAO {
	
	@Autowired
	private LocalityRep localityRep;
	@Autowired
	private WaterTankRepo wtRepo;
	
	
	public String getWelcome() {
		return "Hi Dao Welcome1";
	}
	
	public List<LocalityPOJO> saveLocality(LocalityPOJO locality){
		
		LocalityEntity le=new LocalityEntity();
		List<WaterTankEntity> wtEntityList=new ArrayList<WaterTankEntity>();
		
		le.setCity(locality.getCity());
		le.setStreetName(locality.getStreetName());
		System.out.println(locality.getWaterTanks());
		for(WaterTankPOJO wtPojoobj : locality.getWaterTanks()) {
			WaterTankEntity wtE =new WaterTankEntity();
			wtE.setCapacity(wtPojoobj.getCapacity());
			wtE.setLastCleanedDate(wtPojoobj.getLastCleanedDate());
			//wtE.getWatertank(wtPojoobj.getWatertank());
			 wtRepo.save(wtE);
			wtEntityList.add(wtE);
		}
		
		le.setWaterTankEntities(wtEntityList);
		
		 localityRep.save(le);
		 
		 return getAllLocality();
		
	}
	
	
	public List <LocalityPOJO> getAllLocality() {	
		
		List<LocalityEntity> lEntityList=localityRep.findAll();
		List<LocalityPOJO> lPojoList=new ArrayList<LocalityPOJO>();
		for(LocalityEntity lEntityListob1 : lEntityList ) {
			
			LocalityPOJO  lPojo=new LocalityPOJO();
			lPojo.setCity(lEntityListob1.getCity());
			lPojo.setLocality(lEntityListob1.getLocality());
			lPojo.setStreetName(lEntityListob1.getStreetName());
			List<WaterTankEntity> wtEntityList=lEntityListob1.getWaterTankEntities();
			List<WaterTankPOJO> wtPojoList=new ArrayList<WaterTankPOJO>();
			for(WaterTankEntity wtEntityListob1 :wtEntityList) {
				WaterTankPOJO wtPojo=new WaterTankPOJO();
				wtPojo.setCapacity(wtEntityListob1.getCapacity());
				wtPojo.setWatertank(wtEntityListob1.getWatertank());
				wtPojo.setLastCleanedDate(wtEntityListob1.getLastCleanedDate());
				
				wtPojoList.add(wtPojo);	
			}
			lPojo.setWaterTanks(wtPojoList);
			lPojoList.add(lPojo);
		}	
		return lPojoList;
	}
	
	
	public List <LocalityPOJO> updateLocality( Integer Id,LocalityPOJO locality)
	{
		//do
		 List <LocalityPOJO> reslPojoList=new ArrayList<LocalityPOJO>();
		
		Optional<LocalityEntity> leCheck =localityRep.findById(Id);
		if(leCheck.isPresent()) {
			LocalityEntity le=new LocalityEntity();
			List<WaterTankEntity> wtEntityList=new ArrayList<WaterTankEntity>();
			le.setLocality(Id);
			le.setCity(locality.getCity());
			le.setStreetName(locality.getStreetName());
			for(WaterTankPOJO wtPojoobj : locality.getWaterTanks()) {
				WaterTankEntity wtE =new WaterTankEntity();
				wtE.setCapacity(wtPojoobj.getCapacity());
				wtE.setLastCleanedDate(wtPojoobj.getLastCleanedDate());
				//wtE.getWatertank(wtPojoobj.getWatertank());
				 wtRepo.saveAndFlush(wtE);
				wtEntityList.add(wtE);
			}
			
			le.setWaterTankEntities(wtEntityList);
			
			 localityRep.saveAndFlush(le);
			 reslPojoList=getLocalityById(Id);
			
			return   reslPojoList;
		}else {
			return   reslPojoList;
		}
	}
	public String deleteLocality(Integer Id)
	{
		Optional<LocalityEntity> leCheck =localityRep.findById(Id);
		if(leCheck.isPresent()) {
			
			localityRep.deleteById(Id);
			
			return  "Locality Id "+Id+"Deleted Successfully";
		} else {
			return  "Id Not Found";
		}
		
	}
	public List <LocalityPOJO> getLocalityById(Integer Id) {	
		LocalityEntity reswtEntity=localityRep.findById(Id).get();
        List<LocalityPOJO> reslPojoList=new ArrayList<LocalityPOJO>();
        LocalityPOJO reslPojo=new LocalityPOJO();
        reslPojo.setCity(reswtEntity.getCity());
        reslPojo.setLocality(reswtEntity.getLocality());
        reslPojo.setStreetName(reswtEntity.getStreetName());
        List<WaterTankPOJO> reswtPojoList=new ArrayList<WaterTankPOJO>();
        for(WaterTankEntity wtEntityListob1 : reswtEntity.getWaterTankEntities() ) {
        	WaterTankPOJO reswtPojo=new WaterTankPOJO();
        	reswtPojo.setCapacity(wtEntityListob1.getCapacity());
        	reswtPojo.setWatertank(wtEntityListob1.getWatertank());
        	reswtPojo.setLastCleanedDate(wtEntityListob1.getLastCleanedDate());
        	reswtPojoList.add(reswtPojo);
        	
        }
        
        reslPojo.setWaterTanks(reswtPojoList);
        reslPojoList.add(reslPojo);
        
		
		return reslPojoList;
	}

}
