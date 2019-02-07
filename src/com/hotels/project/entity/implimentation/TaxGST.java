package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Tax;
import com.hotels.project.entity.dto.TaxDTO;

public class TaxGST implements Tax {

	TaxDTO tax;

	@Override
	public TaxDTO getTax() {
		return tax;
	}

	public void setTax(TaxDTO tax) {
		this.tax = tax;
	}

	@Override
	public void executeTaxRule() {
		// nothing
	}

	@Override
	public String toString() {
		return tax.getTaxName() + ":" + tax.getPercentage() + "%";
	}

	@Override
	public int hashCode() {
		return tax.getTaxName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Tax))
			return false;
		if (obj == this)
			return true;
		return this.tax.getTaxName().equals(((Tax) obj).getTax().getTaxName());
	}

}
