package com.example.demo.model;

public class CityVendor {
 
	 private String cityId;
	 private String cityName;
	 private double latitude;
	 private double longtitude;
	
	 public CityVendor(String cityId, String cityName, double latitude, double longtitude) {
		super();
		
		this.cityId = cityId;
		this.cityName = cityName;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}
	 

	
	 public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	
}
