package com.hobgobllin.mulralcultural.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;

@Embeddable
public class Image {

	@Lob
	@Column(columnDefinition = "text")
	private String image;
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
}
