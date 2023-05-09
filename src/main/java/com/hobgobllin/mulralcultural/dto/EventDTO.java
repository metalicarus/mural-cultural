package com.hobgobllin.mulralcultural.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hobgobllin.mulralcultural.entity.Artist;
import com.hobgobllin.mulralcultural.entity.ConcertHall;
import com.hobgobllin.mulralcultural.entity.Event;
import com.hobgobllin.mulralcultural.type.EventCategory;

public class EventDTO {

    private Long id;
    private List<Long> artistIds;
    private List<Long> hallIds;
    private List<SocialNetworkDTO> socialNetworks;
    private List<ImageDTO> images;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EventCategory category;

    public EventDTO() {}

    public EventDTO(Long id, List<Long> artistIds, List<Long> hallIds, List<SocialNetworkDTO> socialNetworks, List<ImageDTO> images, LocalDateTime startDate, LocalDateTime endDate, EventCategory category) {
        this.id = id;
        this.artistIds = artistIds;
        this.hallIds = hallIds;
        this.socialNetworks = socialNetworks;
        this.images = images;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
    }
 
    public static EventDTO fromEvent(Event event) {
        List<Long> artistIds = event.getArtists().stream().map(Artist::getId).collect(Collectors.toList());
        List<Long> hallIds = event.getHalls().stream().map(ConcertHall::getId).collect(Collectors.toList());
        List<SocialNetworkDTO> socialNetworks = event.getLinks().stream().map(SocialNetworkDTO::fromSocialNetwork).collect(Collectors.toList());
        List<ImageDTO> images = event.getImages().stream().map(ImageDTO::toDto).collect(Collectors.toList());

        return new EventDTO(
                event.getId(),
                artistIds,
                hallIds,
                socialNetworks,
                images,
                event.getStartDate(),
                event.getEndDate(),
                event.getCategory()
        );
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getArtistIds() {
		return artistIds;
	}

	public void setArtistIds(List<Long> artistIds) {
		this.artistIds = artistIds;
	}

	public List<Long> getHallIds() {
		return hallIds;
	}

	public void setHallIds(List<Long> hallIds) {
		this.hallIds = hallIds;
	}

	public List<SocialNetworkDTO> getSocialNetworks() {
		return socialNetworks;
	}

	public void setSocialNetworks(List<SocialNetworkDTO> socialNetworks) {
		this.socialNetworks = socialNetworks;
	}

	public List<ImageDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageDTO> images) {
		this.images = images;
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

	public Event toEvent() {
        Event event = new Event();
        event.setId(this.getId());
        event.setArtists(new ArrayList<>());
        event.setHalls(new ArrayList<>());
        event.getLinks().clear();
        event.getImages().clear();
        event.setStartDate(this.getStartDate());
        event.setEndDate(this.getEndDate());
        event.setCategory(this.getCategory());

        return event;
    }
}
