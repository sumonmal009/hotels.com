package com.hotels.project.entity.factory;

import com.hotels.project.common.EntityMetadata;
import com.hotels.project.entity.Category;
import com.hotels.project.entity.Item;
import com.hotels.project.entity.Tax;
import com.hotels.project.entity.implimentation.CategoryGeneral;
import com.hotels.project.entity.implimentation.CategoryGift;
import com.hotels.project.entity.implimentation.CategoryHeavyWeight;
import com.hotels.project.entity.implimentation.CategoryKids;
import com.hotels.project.entity.implimentation.CategoryMedicine;
import com.hotels.project.entity.implimentation.CategoryNewArrival;
import com.hotels.project.entity.implimentation.CategoryNull;
import com.hotels.project.entity.implimentation.ItemNull;
import com.hotels.project.entity.implimentation.TaxNull;
import com.hotels.project.exception.InvalidRequestException;

public class NullFactory extends AbstractFactory {

	public NullFactory()  {
		System.out.println("Not an available type of Factory.");
		throw new InvalidRequestException();
		
	}

	@Override
	public Category getCategory(EntityMetadata category) {

		return new CategoryNull();
	}

	@Override
	public Item getItem(EntityMetadata itemType) {
		return new ItemNull();
	}

	@Override
	public Tax getTax(EntityMetadata taxType) {
		return new TaxNull();
	}

}
