package com.hotels.project.entity;

import com.hotels.project.entity.dto.ItemDTO;

public interface Item {
	public ItemDTO getItem();

	void executeItemRule();

	Packing packing();

}
