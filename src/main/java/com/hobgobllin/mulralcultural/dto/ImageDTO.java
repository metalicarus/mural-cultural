package com.hobgobllin.mulralcultural.dto;

import com.hobgobllin.mulralcultural.entity.Image;

public class ImageDTO {

	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public static ImageDTO toDto(Image entity) {
		ImageDTO dto = new ImageDTO();
		dto.setImage(entity.getImage());
		return dto;
	}
}
