package com.hobgobllin.mulralcultural.controller;

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

import com.hobgobllin.mulralcultural.entity.ConcertHall;
import com.hobgobllin.mulralcultural.repository.ConcertHallRepository;

@RestController
@RequestMapping("/api")
public class ConcertHallController {
    
    @Autowired
    private ConcertHallRepository concertHallRepository;
    
    @GetMapping("/concertHalls")
    public List<ConcertHall> getAllConcertHalls() {
        return concertHallRepository.findAll();
    }
    
    @GetMapping("/concertHalls/{id}")
    public ResponseEntity<ConcertHall> getConcertHallById(@PathVariable(value = "id") Long concertHallId) {
        Optional<ConcertHall> concertHall = concertHallRepository.findById(concertHallId);
        if (concertHall.isPresent()) {
            return ResponseEntity.ok().body(concertHall.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/concertHalls")
    public ConcertHall createConcertHall(@RequestBody ConcertHall concertHall) {
        return concertHallRepository.save(concertHall);
    }
    
    @PutMapping("/concertHalls/{id}")
    public ResponseEntity<ConcertHall> updateConcertHall(@PathVariable(value = "id") Long concertHallId,
            @RequestBody ConcertHall concertHallDetails) {
        Optional<ConcertHall> optionalConcertHall = concertHallRepository.findById(concertHallId);
        if (optionalConcertHall.isPresent()) {
            ConcertHall concertHall = optionalConcertHall.get();
            concertHall.setName(concertHallDetails.getName());
            concertHall.setAddress(concertHallDetails.getAddress());
            concertHall.setCapacity(concertHallDetails.getCapacity());
            return ResponseEntity.ok(concertHallRepository.save(concertHall));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/concertHalls/{id}")
    public ResponseEntity<ConcertHall> deleteConcertHall(@PathVariable(value = "id") Long concertHallId) {
        Optional<ConcertHall> optionalConcertHall = concertHallRepository.findById(concertHallId);
        if (optionalConcertHall.isPresent()) {
            concertHallRepository.delete(optionalConcertHall.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
