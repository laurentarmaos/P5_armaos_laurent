package com.safetynet.safetynetalert.domain.dtos;

public class FireStationDto {

	private String address;
	private int station;
	
	public FireStationDto() {
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "FireStationDto [address=" + address + ", station=" + station + "]";
	}
	
	
}
