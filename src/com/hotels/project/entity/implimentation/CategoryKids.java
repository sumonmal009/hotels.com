package com.hotels.project.entity.implimentation;

import java.util.HashSet;
import java.util.Set;

import com.hotels.project.entity.Category;
import com.hotels.project.entity.Item;
import com.hotels.project.entity.Tax;

public class CategoryKids implements Category {
	String categoryName;
	String categoryID;
	float discount;
	Set<Item> items = new HashSet<>();
	Set<Tax> applicableTaxs = new HashSet<>();

	@Override
	public String getCategoryName() {
		return categoryName;
	}

	@Override
	public String getCategoryID() {
		return categoryID;
	}

	@Override
	public Set<Item> getItems() {
		return items;
	}

	@Override
	public Set<Tax> getApplicableTaxs() {
		return applicableTaxs;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public void setApplicableTaxs(Set<Tax> applicableTaxs) {
		this.applicableTaxs = applicableTaxs;
	}

	@Override
	public void executeCategorySpecificRule() {
		System.out.println("\tTODO: Verify the age before saling");
	}

	@Override
	public int hashCode() {
		return getCategoryName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Category))
			return false;
		if (obj == this)
			return true;
		return this.getCategoryName().equals(((Category) obj).getCategoryName());
	}

	@Override
	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

}
