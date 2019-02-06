package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Packing;

public class PackingPouch implements Packing {

	@Override
	public String pack() {
		return "Pack in Pouch";
	}
}