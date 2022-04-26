package com.inetbanking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	public Properties prop;

	public ConfigDataProvider(String configdatapath) {
		try {
			File fs = new File(configdatapath);
			FileInputStream fins = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fins);
		} catch (Exception e) {
			System.out.println("file not found : " + e);
		}

	}

	public String searchKey(String Key) {
		return prop.getProperty(Key);
	}

	public String getUserName() {
		return prop.getProperty("username");
	}

	public String getPwrd() {
		return prop.getProperty("password");
	}

	public String getUrl() {
		return prop.getProperty("url");
	}
}
