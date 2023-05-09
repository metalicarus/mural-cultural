package com.hobgobllin.mulralcultural.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class SocialNetwork {

	private String link;

	public SocialNetwork() {}
	
	public SocialNetwork(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
