package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Packing;

public class PackingGiftWrap implements Packing {

	@Override
	public String pack() {
		return "Gift Wrapped";
	}
}