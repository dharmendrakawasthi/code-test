package com.ge.exercise1;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyParser implements Parser {

    private static final Logger logger = LogManager.getLogger(MyParser.class);

	public MyParser() {}
	
	@Override
	public Application parseApplicationData(String data) {
		
		Application application = null;
		
//		Convert the input string to the JSON format
		String newSt = convertTiJSON(data);
		
	/*		
	 *	1)  Map the string to the application object
	 *    using the ObjectMapper class of com.fasterxml.jackson.databind.ObjectMapper
	 *  2) then read the value to the Application object and return
	*/	
		try {
			ObjectMapper mapper = new ObjectMapper();
			application = mapper.readValue(newSt, ApplicationImpl.class);

		} catch (Exception e) {
			logger.log(null, "Error occured",e.getMessage());
		}
		return application;
	}

	private static String convertTiJSON(String data) {

//		Replace the "(" with ":{" and ")" with "}"
		data = data.replace("(", ":{").replace(")", "}");
		
		StringBuilder str = new StringBuilder();
		
//		Tockenize the string and store in a ArrayList
		List<String> strList= Arrays.asList(data.split(":"));
		
//		Loop through list and replace the required string parts
		for(String st: strList){
			if(st.contains("[")){	
				st = "[";
			}
			if(st.contains("},")){
				st = st.substring(0, st.indexOf(","));
			}
			if(st.contains(",")){
				st = st.replace(",", "\",\"");
			}
			
			str.append("\""+st+"\":");
		}
//		some more replacements to convert it to JSON format
		str = new StringBuilder(str.toString().replace("\"[", "[\"").replace("{", "{\"").replace("}", "\"}")
				.replace(":\"{", ":{").replace("]\"", "]").replace("}\"", "}").replace(":}","}").replace(":\"{", ":{\"")
				.replace("[\"\":", "[").replace(":}", "}").replace("\" ", "\"").replace("}:{", "},{"));

		return str.substring(str.indexOf("{"),str.length()-1);
	}

}
