package com.hotels.project.entity;

import java.util.Set;

public interface Category {

	String getCategoryName();

	String getCategoryID();

	Set<Item> getItems();

	Set<Tax> getApplicableTaxs();

	float getDiscount();

	void executeCategorySpecificRule();
}
