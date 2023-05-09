package com.hobgobllin.mulralcultural.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hobgobllin.mulralcultural.entity.Event;
import com.hobgobllin.mulralcultural.repository.EventRepository;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            return ResponseEntity.ok().body(optionalEvent.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        try {
            Event savedEvent = eventRepository.save(event);
            return ResponseEntity.created(new URI("/api/events/" + savedEvent.getId())).body(savedEvent);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long eventId,
                                              @RequestBody Event eventDetails) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setName(eventDetails.getName());
            event.setCategory(eventDetails.getCategory());
            event.setStartDate(eventDetails.getStartDate());
            event.setEndDate(eventDetails.getEndDate());
            event.setHalls(eventDetails.getHalls());
            event.setArtists(eventDetails.getArtists());
            return ResponseEntity.ok(eventRepository.save(event));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable(value = "id") Long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            eventRepository.delete(optionalEvent.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

