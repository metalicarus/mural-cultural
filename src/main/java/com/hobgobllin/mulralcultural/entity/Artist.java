package com.hobgobllin.mulralcultural.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity {

	@ManyToMany(mappedBy = "artists")
	private List<Event> events = new ArrayList<>();

	public Artist() {
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void addEvent(Event event) {
		events.add(event);
		event.getArtists().add(this);
	}
	
	public void removeEvent(Event event) {
		events.remove(event);
		event.getArtists().remove(this);
	}

	@Override
	public String toString() {
		return "Artist{" + "id=" + getId() + ", name='" + getName() + '\'' + '}';
	}
}
