package com.example.agricultureguide.model;

public class Crop {
	private String period;
	private String name;
	private int imgId;

	public Crop(String period, String name, int imgId) {
		this.period = period;
		this.name = name;
		this.imgId = imgId;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
}
