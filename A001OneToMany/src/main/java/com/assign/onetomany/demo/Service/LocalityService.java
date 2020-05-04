package com.assign.onetomany.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.assign.onetomany.demo.Dao.LocalityDAO;
import com.assign.onetomany.demo.Entity.LocalityEntity;
import com.assign.onetomany.demo.pojo.LocalityPOJO;

@Service
public class LocalityService {

	@Autowired
	private LocalityDAO localityDao;
	
	public String getWelcome() {
		return localityDao.getWelcome();
	}

	
	public List<LocalityPOJO> saveLocality(LocalityPOJO locality){
		
		return localityDao.saveLocality(locality);
		
	}

	public List <LocalityPOJO> getAllLocality() {	
		return localityDao.getAllLocality();
	}
	
	
	public List <LocalityPOJO> updateLocality( Integer Id,LocalityPOJO locality)
	{
		
		return  localityDao.updateLocality(Id,locality);
	}
	
	public String deleteLocality(Integer Id)
	{
		return  localityDao.deleteLocality(Id);
	}
}
