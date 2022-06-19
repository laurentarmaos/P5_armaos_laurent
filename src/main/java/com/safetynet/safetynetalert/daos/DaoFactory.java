package com.safetynet.safetynetalert.daos;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DaoFactory {


	public DaoFactory (){}
	
	public JSONObject connectToJson() {
				
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("data.json"));
			JSONObject jsonObject = (JSONObject) obj;	
			return jsonObject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;	
		}
	}
}
