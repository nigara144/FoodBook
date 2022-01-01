package com.example.foodbook.boundaryhelpers;


//helper class for instance boundary
public class Location {
	private Double lat;
	private Double lng;

	public Location() {

	}

	public Location(Double lat, Double lng) {
		this.lat = lat;
		this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lng == null) ? 0 : lng.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (this.lat.equals(other.getLat()) && this.lng.equals(other.getLng())) {
			return true;
		}
		return false;
	}
}
