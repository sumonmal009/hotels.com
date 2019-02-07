package com.hotels.project.entity.dto;

import java.util.HashSet;
import java.util.Set;

import com.hotels.project.entity.Tax;

public class ItemDTO {
	String itemID;
	String itemName;
	float itemPrice;
	float discount;
	Set<Tax> taxes = new HashSet<>();

	public String getItemID() {
		return itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public float getDiscount() {
		return discount;
	}

	public Set<Tax> getApplicableTaxs() {
		return taxes;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public void setTaxes(Set<Tax> taxes) {
		this.taxes = taxes;
	}
}
