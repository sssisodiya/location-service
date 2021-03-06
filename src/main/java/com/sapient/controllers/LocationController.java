package com.sapient.controllers;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.models.Location;
import com.sapient.repositories.LocationRepository;

@RestController
public class LocationController {
    // to test i am updating something here ... 
	@Autowired
	LocationRepository locationRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/locations")
	public Iterable<Location> Location() {
		return locationRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/locations")
	@ResponseBody
	public String save(@RequestBody Location location) {
		
		location.setCreatedDate(new Date());
		location.setModifiedDate(new Date());

		locationRepository.save(location);
		
		return "{'id' : '"+location.getId()+"'}";
	}

	@RequestMapping(method = RequestMethod.GET, value = "locations/{id}")
	public Location show(@PathVariable String id) {

		return locationRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "locations/{id}")
	public Location update(@PathVariable String id, @RequestBody Location location) {

		Location loc = locationRepository.findOne(id);
		loc.setModifiedDate(new Date());
		if (loc.getCode() != null) {
			loc.setCode(location.getCode());
		}
		if (loc.getDescription() != null) {
			loc.setDescription(location.getDescription());
		}

		loc.setModifiedDate(new Date());
		locationRepository.save(loc);

		return loc;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/locations/{id}")
	@ResponseBody
	public String delete(@PathVariable String id) {

		locationRepository.delete(id);
		return "{'status' : 'OK'}";
		
	}

}
