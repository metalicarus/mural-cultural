package com.hobgobllin.mulralcultural.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.hobgobllin.mulralcultural.type.EventCategory;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event extends BaseEntity {

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
    
    @ElementCollection
	@CollectionTable(name= "event_social_networks", 
			joinColumns = @JoinColumn(name= "event_id"))
	@AttributeOverrides({
		@AttributeOverride(name= "link", column= @Column(name= "social_network_link")),
		@AttributeOverride(name= "name", column= @Column(name= "social_network_link_name"))
	})
	private List<SocialNetwork> links;
	
	@ElementCollection
	@CollectionTable(name= "event_images", 
			joinColumns = @JoinColumn(name= "artist_id"))
	@AttributeOverrides({
		@AttributeOverride(name= "image", column= @Column(name= "event_image")),
	})
	private List<Image> images;

    
    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventCategory category;
 
    public Event() {
    }
 
    public Event(Long id, List<Artist> artists, List<ConcertHall> halls, String name, LocalDateTime startDate,
			LocalDateTime endDate, EventCategory category, String description) {
		super();
		setId(id);
		this.artists = artists;
		this.halls = halls;
		setName(name);
		this.startDate = startDate;
		this.endDate = endDate;
		this.category = category;
		setDescription(description);
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
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", category=" + category +
                ", description='" + getDescription() + '\'' +
                '}';
    }

	public List<SocialNetwork> getLinks() {
		return links;
	}

	public void setLinks(List<SocialNetwork> links) {
		this.links = links;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
 
}
