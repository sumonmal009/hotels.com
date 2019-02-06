package com.hotels.project.entity;

import java.util.Set;

public interface Item {
	String getItemName();

	float getItemPrice();

	Set<Tax> getApplicableTaxs();

	void executeItemRule();

	float getDiscount();

	Packing packing();

}
