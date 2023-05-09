package com.hobgobllin.mulralcultural.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "artists")
    private List<Event> events = new ArrayList<>();

    @Column(nullable = false)
    private String name;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // convenience method to add an event

    public void addEvent(Event event) {
        events.add(event);
        event.getArtists().add(this);
    }

    // convenience method to remove an event

    public void removeEvent(Event event) {
        events.remove(event);
        event.getArtists().remove(this);
    }

    // toString method for debugging purposes

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

