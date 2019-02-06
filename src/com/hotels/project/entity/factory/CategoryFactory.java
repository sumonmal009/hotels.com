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

		default:
			return null;
		}
	}

//------------------------------------------------------

	@Override
	public Item getItem(EntityMetadata itemType) {
		return null;
	}

	@Override
	public Tax getTax(EntityMetadata taxType) {
		return null;
	}

}
