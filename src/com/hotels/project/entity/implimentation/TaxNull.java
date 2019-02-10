package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Tax;
import com.hotels.project.entity.dto.TaxDTO;
import com.hotels.project.exception.InvalidRequestException;

public class TaxNull implements Tax {

	TaxDTO tax;

	public TaxNull() {
		executeTaxRule();
	}

	@Override
	public TaxDTO getTax() {
		executeTaxRule();
		return null;
	}

	public void setTax(TaxDTO tax) {
		executeTaxRule();
		this.tax = null;
	}

	@Override
	public void executeTaxRule() {
		System.out.println("Not an available type of tax.");
		throw new InvalidRequestException();
	}

}
