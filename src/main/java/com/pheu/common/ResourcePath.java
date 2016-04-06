package com.pheu.common;

import java.net.URL;

public class ResourcePath {

	private ResourcePath() {}
	
	public static URL getResourceURL(String file) {
		return PropertyLoader.class.getClassLoader().getResource(file);
	}
	
}
