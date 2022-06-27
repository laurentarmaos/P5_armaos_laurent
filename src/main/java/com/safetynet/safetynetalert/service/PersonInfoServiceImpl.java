package com.safetynet.safetynetalert.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalert.dao.PersonInfoDao;
import com.safetynet.safetynetalert.domain.dtos.AllergyDto;
import com.safetynet.safetynetalert.domain.dtos.MedicationDto;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;



@Service
public class PersonInfoServiceImpl implements PersonInfoService{

	private final PersonInfoDao personInfoDao;
	
	public PersonInfoServiceImpl(PersonInfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}

	
	
	@Override
	public void personInfo(String firstName, String lastName) {

		//boucle sur le tableau "persons"
		for(int i = 0; i < personInfoDao.getPerson().size(); i++) {
					
			JSONObject jsonPerson = (JSONObject) personInfoDao.getPerson().get(i);
			
			//boucle sur le tableau "medicalRecords"
			for(int k = 0; k < personInfoDao.getMedic().size(); k++) {
				JSONObject jsonMedic = (JSONObject) personInfoDao.getMedic().get(k);
				
				// vérification que la ligne k de "medicalRecords" correspond à la ligne i de "persons" en comparant les noms et prénoms des personnes
				if( jsonPerson.get("firstName").equals(jsonMedic.get("firstName")) && jsonPerson.get("lastName").equals(jsonMedic.get("lastName")) ) {
					
					// création des objets dto
					AllergyDto allergy = new AllergyDto();
					MedicationDto medication = new MedicationDto();
					PersonDto person = new PersonDto();
					
					// instanciation des objets dto
					person.setFirstName((String) jsonPerson.get("firstName"));
					person.setLastName((String) jsonPerson.get("lastName"));
					person.setAddress((String) jsonPerson.get("address"));
					person.setCity((String) jsonPerson.get("city"));
					person.setPhone((String) jsonPerson.get("phone"));
					person.setZipCode((String) jsonPerson.get("zip"));
					person.setEmail((String) jsonPerson.get("email"));
					
					SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					String dateString = (String) jsonMedic.get("birthdate");
					Date birthDate;
					try {
						birthDate = formatter.parse(dateString);
						person.setBirthDate(birthDate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
										
					
					
					// récupération de la liste des médicaments et allergies pour les ajouter dans PersonDto
					JSONArray medic = (JSONArray) jsonMedic.get("medications");
					JSONArray allerg = (JSONArray) jsonMedic.get("allergies");
				
					Set<String> medicList = new HashSet<String>();
					for(int j = 0; j < medic.size(); j++) {
							
						medication.setMedicationName((String) medic.get(j));
						medicList.add(medication.getMedicationName());
					}
					person.setMedications(medicList);
					
					
					Set<String> allergList = new HashSet<String>();
					for(int j = 0; j < allerg.size(); j++) {
						allergy.setAllergyName((String) allerg.get(j));
						allergList.add(allergy.getAllergyName());
					}		
					person.setAllergies(allergList);

					
					// récupère les informations de la personne dont le nom et prénom sont écrits dans l'url
					if(firstName.equalsIgnoreCase(person.getFirstName()) && lastName.equalsIgnoreCase(person.getLastName())) {
						Date date = new Date();
						System.out.println("Prénom : " + person.getFirstName() + ", Nom : " + person.getLastName() + ", Age : " + Math.ceil((date.getTime() - person.getBirthDate().getTime())/(86400 * 1000 * 365.24)) + ", Adresse : " + person.getAddress() + ", Email : " + person.getEmail()  + ", Médicaments : " + person.getMedications() + ", Allergies : " + person.getAllergies() );
					}			
				}
			}
		}
	}	
}
