package com.hotels.project.entity.dto;

public class TaxDTO {
	float percentage;
	String taxID;
	String taxName;

	public float getPercentage() {
		return percentage;
	}

	public String getTaxID() {
		return taxID;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

}
