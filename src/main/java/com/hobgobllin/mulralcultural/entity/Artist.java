package com.hobgobllin.mulralcultural.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity {

	@ManyToMany(mappedBy = "artists")
	private List<Event> events = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name= "artist_social_networks", 
			joinColumns = @JoinColumn(name= "artist_id"))
	@AttributeOverrides({
		@AttributeOverride(name= "link", column= @Column(name= "social_network_link")),
	})
	private List<SocialNetwork> links;
	
	@ElementCollection
	@CollectionTable(name= "artist_images", 
			joinColumns = @JoinColumn(name= "artist_id"))
	@AttributeOverrides({
		@AttributeOverride(name= "image", column= @Column(name= "artist_image")),
	})
	private List<Image> images;
	
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
