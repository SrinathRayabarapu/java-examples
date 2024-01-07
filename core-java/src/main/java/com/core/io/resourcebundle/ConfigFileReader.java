package com.core.io.resourcebundle;

import java.util.Properties;

public class ConfigFileReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigFileReader fileReader = new ConfigFileReader();
		String value = fileReader.getProperty("author");
		System.out.println("Value read from Config file: "+value);
	}

	public ConfigFileReader() {
		loadConfig();
	}
	
	Properties configFile;
	
	public void loadConfig() {
		this.configFile = new java.util.Properties();
		try {
			this.configFile.load(this.getClass().getClassLoader().getResourceAsStream("config/appConfig.cfg"));
			System.out.println("Configuration file loaded succesfully");
		} catch (Exception eta) {
			eta.printStackTrace();
		}
	}

	public String getProperty(String key) {
		String value = this.configFile.getProperty(key);
		return value;
	}

}