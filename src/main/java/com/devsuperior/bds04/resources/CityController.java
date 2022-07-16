package com.devsuperior.bds04.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.service.CityService;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@GetMapping
	public ResponseEntity<List<CityDTO>> findAll(){
		
		List<CityDTO> cities = cityService.findAll();
		
		return ResponseEntity.ok().body(cities);
		
		
	}
	
	@PostMapping
	public ResponseEntity<CityDTO> insert(@Valid @RequestBody CityDTO dto){
		 
		CityDTO cityDto = cityService.insert(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		
		dto = cityService.insert(dto);
		return ResponseEntity.created(uri).body(dto);
	
		
	}

}
