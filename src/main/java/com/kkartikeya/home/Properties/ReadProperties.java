package com.kkartikeya.home.Properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties
{
	public static void main( String[] args )
	{
		ReadProperties readProp = new ReadProperties();
		Properties prop = readProp.readProperties();

		System.out.println(prop.getProperty("face.kairos.app_id"));
		System.out.println(prop.getProperty("face.kairos.app_key"));
		
	}

	public Properties readProperties() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);

		}catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if (input != null) {
				try {
					input.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}
		
		return prop;
	}
}
