package com.devsuperior.bds04.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	
	public List<CityDTO> findAll() {
		
		List<City> cities = cityRepository.findAll(Sort.by("name"));
		
		
		return cities.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
		
	}


	public CityDTO insert(CityDTO dto) {
		
		City city = new City();		
		city.setName(dto.getName());		
		city = cityRepository.save(city);		
		
		return new CityDTO(city);
	}
	
	
	

}
