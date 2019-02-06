package com.hotels.project.entity.factory;

import com.hotels.project.common.EntityMetadata;
import com.hotels.project.entity.Category;
import com.hotels.project.entity.Item;
import com.hotels.project.entity.Tax;
import com.hotels.project.entity.implimentation.TaxGST;
import com.hotels.project.entity.implimentation.TaxSales;

public class TaxFactory extends AbstractFactory {

	@Override
	public Tax getTax(EntityMetadata tax) {

		switch (tax) {
		case TAX_SALES:
			return new TaxSales();
		case TAX_GST:
			return new TaxGST();

		default:
			return null;
		}

	}

// ------------------------------------------------------

	@Override
	public Item getItem(EntityMetadata itemType) {
		return null;
	}

	@Override
	public Category getCategory(EntityMetadata categoryType) {
		return null;
	}

}
