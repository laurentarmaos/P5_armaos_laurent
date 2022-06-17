package com.safetynet.safetynetalert.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Person extends AbstractModel{

		private String firstName;
		private String lastName;
		private Date birthDate;
		private String address;
		private String city;
		private String zipCode;
		private String phone;
		private String email;
		Set <Allergy> allergies = new HashSet <Allergy>();
		Set <Medication> medications = new HashSet <Medication>();

		
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

		
		public Date getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
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
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
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


		public Set <Allergy> getAllergies() {
			return allergies;
		}

		public void setAllergies(Set <Allergy> allergies) {
			this.allergies = allergies;
		}


		public Set <Medication> getMedications() {
			return medications;
		}

		public void setMedications(Set <Medication> medications) {
			this.medications = medications;
		}


		@Override
		public String toString() {
			return "Person [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
					+ ", address=" + address + ", city=" + city + ", zipCode=" + zipCode + ", phone=" + phone
					+ ", email=" + email + ", allergies=" + allergies + ", medications=" + medications + "]";
		}
		
		
}
