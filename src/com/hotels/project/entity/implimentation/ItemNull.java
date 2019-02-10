package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Item;
import com.hotels.project.entity.Packing;
import com.hotels.project.entity.dto.ItemDTO;
import com.hotels.project.exception.InvalidRequestException;

public class ItemNull implements Item {

	ItemDTO item;

	public ItemNull() {
		executeItemRule();
	}

	@Override
	public ItemDTO getItem() {
		return null;
	}

	public void setItem(ItemDTO item) {
		executeItemRule();
		this.item = null;
	}

	@Override
	public void executeItemRule() {
		System.out.println("Not an available type of item.");
		throw new InvalidRequestException();

	}

	@Override
	public Packing packing() {
		executeItemRule();
		return null;

	}

}
