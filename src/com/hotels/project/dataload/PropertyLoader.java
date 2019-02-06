package com.hotels.project.dataload;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

	private Properties prop = null;

	public Properties getConfigValues() {

		InputStream is = null;
		try {
			prop = new Properties();
			is = this.getClass().getResourceAsStream("/application.properties");
			prop.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return prop;
		}
	}

}
