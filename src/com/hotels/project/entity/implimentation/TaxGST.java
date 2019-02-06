package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Tax;

public class TaxGST implements Tax {

	float percentage;
	String taxID;
	String taxName;

	@Override
	public float getPercentage() {
		return percentage;
	}

	public String getTaxID() {
		return taxID;
	}

	@Override
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

	@Override
	public void executeTaxRule() {
		// nothing
	}

	@Override
	public String toString() {
		return getTaxName() + ":" + getPercentage() + "%";
	}

	@Override
	public int hashCode() {
		return getTaxName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Tax))
			return false;
		if (obj == this)
			return true;
		return this.getTaxName().equals(((Tax) obj).getTaxName());
	}

}
