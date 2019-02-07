package com.hotels.project.cart;

import java.util.Map;

import com.hotels.project.common.Configuration;
import com.hotels.project.entity.Item;

public class Packer {
	public Packer() {
		boolean showItemGuildlineInfo = Boolean
				.valueOf(Configuration.ConfigValues.getProperty("show.item.guideline.info"));
		boolean showCategoryGuildlineInfo = Boolean
				.valueOf(Configuration.ConfigValues.getProperty("show.category.guideline.info"));
		boolean packingRequired = Boolean.valueOf(Configuration.ConfigValues.getProperty("packing.required"));

		if (packingRequired) {
			System.out.println("\nPacking for you.\n--------------------");
			Item item;
			InfoPrinter infoPrinter = new InfoPrinter();

			for (Map.Entry<Item, Integer> itemEntry : CustomersCart.getCart().entrySet()) {
				item = itemEntry.getKey();
				System.out.println("Packing " + item.getItem().getItemName() + ". " + item.packing().pack());
				if (showItemGuildlineInfo) {
					infoPrinter.printItemGuidelineInfo(item);
				}
				if (showCategoryGuildlineInfo) {
					infoPrinter.printCategoryGuidelineInfo(item);
				}
			}
		}
	}
}
