package com.devsuperior.bds04.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;



@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	public Page<EventDTO> findPaged(Pageable pageable){
		
		Page<Event> events = eventRepository.findAll(pageable);
				
		return events.map(x -> new EventDTO(x));
	}

	@Transactional
	public EventDTO insert(EventDTO dto) {
		
		Event event = new Event();
		event.setName(dto.getName());
		event.setDate(dto.getDate());
		event.setUrl(dto.getUrl());
		event.setCity(new City(dto.getCityId(),null));
		
		event = eventRepository.save(event);
		
		return new EventDTO(event);
	
		}
		
		
		
		
		
	
	
}
