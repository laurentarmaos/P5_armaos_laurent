package com.safetynet.safetynetalert.domain.entities;


public class Person extends AbstractModel{

		private String firstName;
		private String lastName;
		private String address;
		private String city;
		private String zip;
		private String phone;
		private String email;

		
		public Person() {
			
		}


		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		
		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}


		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}


		public String getZipCode() {
			return zip;
		}

		public void setZipCode(String zipCode) {
			this.zip = zipCode;
		}


		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}


		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		
		@Override
		public String toString() {
			return "Person [firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
					+ ", address=" + address + ", city=" + city + ", zipCode=" + zip + ", phone=" + phone
					+ ", email=" + email + "]";
		}
		
		
}
