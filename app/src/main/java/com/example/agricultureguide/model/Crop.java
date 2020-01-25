package com.example.agricultureguide.model;

public class Crop {
	private String period;
	private String name;
	private String imgId;

	public Crop(String name, String imgId) {
		this.name = name;
		this.imgId = imgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
}
