package com.hotels.project.entity.factory;

import com.hotels.project.common.EntityMetadata;
import com.hotels.project.entity.Category;
import com.hotels.project.entity.Item;
import com.hotels.project.entity.Tax;
import com.hotels.project.entity.implimentation.ItemFragile;
import com.hotels.project.entity.implimentation.ItemGift;
import com.hotels.project.entity.implimentation.ItemGrocerry;
import com.hotels.project.entity.implimentation.ItemHeavy;
import com.hotels.project.entity.implimentation.ItemMedicine;

public class ItemFactory extends AbstractFactory {

	@Override
	public Item getItem(EntityMetadata item) {

		switch (item) {
		case ITEM_GROCERRY:
			return new ItemGrocerry();
		case ITEM_FRAGILE:
			return new ItemFragile();
		case ITEM_GIFT:
			return new ItemGift();
		case ITEM_HEAVY:
			return new ItemHeavy();
		case ITEM_MEDICINE:
			return new ItemMedicine();
		default:
			return null;
		}
	}

//------------------------------------------------------
	@Override
	public Tax getTax(EntityMetadata taxType) {
		return null;
	}

	@Override
	public Category getCategory(EntityMetadata categoryType) {
		return null;
	}

}
