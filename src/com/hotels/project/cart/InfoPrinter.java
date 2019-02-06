package com.hotels.project.cart;

import com.hotels.project.dataload.DataFeeder;
import com.hotels.project.entity.Category;
import com.hotels.project.entity.Item;

public class InfoPrinter {

	public void printItemGuidelineInfo(Item item) {
		item.executeItemRule();
	}

	public void printCategoryGuidelineInfo(Item item) {
		for (Category category : DataFeeder.itemCategoryMapping.get(item)) {
			category.executeCategorySpecificRule();
		}
	}

}
