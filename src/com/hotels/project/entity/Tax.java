package com.hotels.project.entity;

public interface Tax {

	String getTaxName();

	float getPercentage();

	void executeTaxRule();

}
