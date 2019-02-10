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

public class CategoryFactory extends AbstractFactory {

	@Override
	public Category getCategory(EntityMetadata category) {

		// EntityMetadata categoryType = EntityMetadata.valueOf(category);

		switch (category) {
		case CATEGORY_GENERAL:
			return new CategoryGeneral();

		case CATEGORY_MEDICINE:
			return new CategoryMedicine();

		case CATEGORY_KIDS:
			return new CategoryKids();
		case CATEGORY_GIFT:
			return new CategoryGift();
		case CATEGORY_HEAVYWEIGHT:
			return new CategoryHeavyWeight();
		case CATEGORY_NEW_ARRIAVEL:
			return new CategoryNewArrival();

		default:
			return new CategoryNull();
		}
	}

//------------------------------------------------------

	@Override
	public Item getItem(EntityMetadata itemType) {
		return new ItemNull();
	}

	@Override
	public Tax getTax(EntityMetadata taxType) {
		return new TaxNull();
	}

}
