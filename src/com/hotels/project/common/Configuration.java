package com.hotels.project.common;

import java.util.Properties;

import com.hotels.project.dataload.PropertyLoader;

public class Configuration {
	public static final Properties ConfigValues = new PropertyLoader().getConfigValues();
}
