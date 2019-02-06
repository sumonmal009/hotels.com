package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Packing;

public class PackingWrapper implements Packing {

	@Override
	public String pack() {
		return "Plastic Wrapper";
	}
}