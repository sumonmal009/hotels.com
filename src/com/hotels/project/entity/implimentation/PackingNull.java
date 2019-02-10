package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Packing;
import com.hotels.project.exception.InvalidRequestException;

public class PackingNull implements Packing {

	public PackingNull() {
		pack();
	}

	@Override
	public String pack() {
		System.out.println("Not an available type of packing.");
		throw new InvalidRequestException();
	}
}