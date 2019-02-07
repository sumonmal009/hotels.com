package com.hotels.project.entity;

import com.hotels.project.entity.dto.TaxDTO;

public interface Tax {

	public TaxDTO getTax();

	void executeTaxRule();

}
