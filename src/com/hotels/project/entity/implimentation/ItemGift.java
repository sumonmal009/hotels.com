package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Item;
import com.hotels.project.entity.Packing;
import com.hotels.project.entity.dto.ItemDTO;

public class ItemGift implements Item {

	ItemDTO item;

	@Override
	public ItemDTO getItem() {
		return item;
	}

	public void setItem(ItemDTO item) {
		this.item = item;
	}

	@Override
	public void executeItemRule() {
		System.out.println("\tINFO: Ask the message to write");

	}

	@Override
	public int hashCode() {
		return item.getItemName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Item))
			return false;
		if (obj == this)
			return true;
		return this.item.getItemName().equals(((Item) obj).getItem().getItemName());
	}

	@Override
	public Packing packing() {

		return new PackingGiftWrap();
	}

}
