package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Packing;

public class PackingCartonBox implements Packing {

	@Override
	public String pack() {
		return "Pack in Box";
	}
}