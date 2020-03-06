package com.ge.exercise1;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ge.exercise3.Account;

public class MyParser implements Parser {

    private static final Logger logger = LogManager.getLogger(MyParser.class);

	private String data;

	public MyParser() {
	}

	public MyParser(String data) {
		this.data = data;
	}

	@Override
	public Application parseApplicationData(String data) {

		Application application = null;

		String newSt = convertTiJSON(data);
		System.out.println(newSt);
		try {

			ObjectMapper mapper = new ObjectMapper();
//			mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			application = mapper.readValue(newSt, ApplicationImpl.class);

		} catch (Exception e) {
			logger.log(null, "Error occured",e.getMessage());
		}
		return application;
	}

	private static String convertTiJSON(String data) {

		data = data.replace("(", ":{").replace(")", "}");
		StringBuilder str = new StringBuilder();
		List<String> strList= Arrays.asList(data.split(":"));
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
		str = new StringBuilder(str.toString().replace("\"[", "[\"").replace("{", "{\"").replace("}", "\"}")
				.replace(":\"{", ":{").replace("]\"", "]").replace("}\"", "}").replace(":}","}").replace(":\"{", ":{\"")
				.replace("[\"\":", "[").replace(":}", "}").replace("\" ", "\"").replace("}:{", "},{"));

		return str.substring(str.indexOf("{"),str.length()-1);
	}

}
