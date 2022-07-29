package com.safetynet.safetynetalert.domain.dtos;

public class FireStationDto {

	private String address;
	private String station;
	
	public FireStationDto() {
		
	}

	public FireStationDto(String address, String station) {
		this.address = address;
		this.station = station;
	}

//	public FireStationDto(String address) {
//		this.address = address;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "FireStationDto [address=" + address + ", station=" + station + "]";
	}
	
	
}
