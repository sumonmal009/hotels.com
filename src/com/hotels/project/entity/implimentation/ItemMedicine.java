package com.hotels.project.entity.implimentation;

import java.util.HashSet;
import java.util.Set;

import com.hotels.project.entity.Item;
import com.hotels.project.entity.Packing;
import com.hotels.project.entity.Tax;

public class ItemMedicine implements Item {

	String itemID;
	String itemName;
	float itemPrice;
	float discount;
	Set<Tax> taxes = new HashSet<>();

	public String getItemID() {
		return itemID;
	}

	@Override
	public String getItemName() {
		return itemName;
	}

	@Override
	public float getItemPrice() {
		return itemPrice;
	}

	@Override
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

	public void setTaxes(Set<Tax> taxes) {
		this.taxes.addAll(taxes);
	}

	@Override
	public void executeItemRule() {
		System.out.println("\tWARNING: Not saleabe to Kids");
	}

	@Override
	public int hashCode() {
		return getItemName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Item))
			return false;
		if (obj == this)
			return true;
		return this.getItemName().equals(((Item) obj).getItemName());
	}

	@Override
	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	@Override
	public Packing packing() {

		return new PackingPouch();
	}

}
