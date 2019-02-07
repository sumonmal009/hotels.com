package com.hotels.project.entity.dto;

import java.util.HashSet;
import java.util.Set;

import com.hotels.project.entity.Item;
import com.hotels.project.entity.Tax;

public class CategoryDTO {
	String categoryName;
	String categoryID;
	float discount;
	Set<Item> items = new HashSet<>();
	Set<Tax> applicableTaxs = new HashSet<>();

	public String getCategoryName() {
		return categoryName;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public float getDiscount() {
		return discount;
	}

	public Set<Item> getItems() {
		return items;
	}

	public Set<Tax> getApplicableTaxs() {
		return applicableTaxs;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public void setApplicableTaxs(Set<Tax> applicableTaxs) {
		this.applicableTaxs = applicableTaxs;
	}
}
