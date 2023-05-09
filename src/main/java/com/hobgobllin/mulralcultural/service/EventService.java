package com.hobgobllin.mulralcultural.service;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.hobgobllin.mulralcultural.dto.EventDTO;
import com.hobgobllin.mulralcultural.entity.Event;
import com.hobgobllin.mulralcultural.repository.EventRepository;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream().map(EventDTO::fromEvent).toList();
    }

    public EventDTO getEventById(Long id) {
        Event e = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found: " + id));
        return EventDTO.fromEvent(e);
    }

    public EventDTO createEvent(EventDTO dto) {
    	Event entity = dto.toEvent();
        eventRepository.save(entity);
        return EventDTO.fromEvent(entity);
    }

//    public EventDTO updateEvent(Long id, EventDTO eventDetails) {
//        Event event = eventRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Event not found: " + id));
//
//        
//        
//        event.setArtists(eventDetails.getArtists());
//        event.setHalls(eventDetails.getHalls());
//        event.setLinks(eventDetails.getLinks());
//        event.setImages(eventDetails.getImages());
//        event.setStartDate(eventDetails.getStartDate());
//        event.setEndDate(eventDetails.getEndDate());
//        event.setCategory(eventDetails.getCategory());
//
//        return eventRepository.save(event);
//    }

//    public void deleteEvent(Long id) {
//        Event event = eventRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", id));
//
//        eventRepository.delete(event);
//    }
}
