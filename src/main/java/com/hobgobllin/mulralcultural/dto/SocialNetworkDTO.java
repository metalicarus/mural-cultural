package com.hobgobllin.mulralcultural.dto;

import com.hobgobllin.mulralcultural.entity.SocialNetwork;

public class SocialNetworkDTO {
    
    private String name;
    private String link;
    
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static SocialNetworkDTO fromSocialNetwork(SocialNetwork entity) {
		SocialNetworkDTO dto = new SocialNetworkDTO();
		dto.setLink(entity.getLink());
		dto.setName(entity.getName());
		return dto;
	}
    
}