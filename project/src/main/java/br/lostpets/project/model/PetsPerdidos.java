package br.lostpets.project.model;

public class PetsPerdidos {

	private double latitude;
	private double longitude;
	private String fotoPet;
		
	public PetsPerdidos(double latitude, double longitude, String fotoPet) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.fotoPet = fotoPet;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getFotoPet() {
		return fotoPet;
	}
	public void setFotoPet(String fotoPet) {
		this.fotoPet = fotoPet;
	}
	
	
	
}
