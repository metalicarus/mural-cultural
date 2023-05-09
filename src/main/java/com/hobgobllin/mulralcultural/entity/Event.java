package com.hobgobllin.mulralcultural.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.hobgobllin.mulralcultural.type.EventCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "event_artists",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private List<Artist> artists = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "event_halls",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "concert_hall_id"))
    private List<ConcertHall> halls = new ArrayList<>();

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventCategory category;

    @Column(nullable = false)
    private String description;

    public Event() {
    }
 
    
	
    public Event(Long id, List<Artist> artists, List<ConcertHall> halls, String name, LocalDateTime startDate,
			LocalDateTime endDate, EventCategory category, String description) {
		super();
		this.id = id;
		this.artists = artists;
		this.halls = halls;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.category = category;
		this.description = description;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public List<Artist> getArtists() {
		return artists;
	}



	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}



	public List<ConcertHall> getHalls() {
		return halls;
	}



	public void setHalls(List<ConcertHall> halls) {
		this.halls = halls;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public LocalDateTime getStartDate() {
		return startDate;
	}



	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}



	public LocalDateTime getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}



	public EventCategory getCategory() {
		return category;
	}



	public void setCategory(EventCategory category) {
		this.category = category;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void addHall(ConcertHall hall) {
    	halls.add(hall);
    }
    
    public void removeHall(ConcertHall hall) {
    	halls.remove(hall);
    }
 
    public void addArtist(Artist artist) {
        artists.add(artist);
        artist.getEvents().add(this);
    }
 
    public void removeArtist(Artist artist) {
        artists.remove(artist);
        artist.getEvents().remove(this);
    }
 
    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}
