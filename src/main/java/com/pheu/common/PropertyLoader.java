package com.pheu.common;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertyLoader {

	private PropertiesConfiguration properties;
	
	public PropertyLoader(String filename) {
		try {
			properties = new PropertiesConfiguration(ResourcePath.getResourceURL(filename));
		} catch (ConfigurationException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public int getInt(String key) {
		return properties.getInt(key);
	}
	
	public float getFloat(String key) {
		return properties.getFloat(key);
	}
	
	public String getString(String key) {
		return properties.getString(key);
	}
	
}
