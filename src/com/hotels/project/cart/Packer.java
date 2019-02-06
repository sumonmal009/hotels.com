package com.hotels.project.cart;

import java.util.Map;

import com.hotels.project.common.Configuration;
import com.hotels.project.entity.Item;

public class Packer {
	public Packer() {
		boolean showItemGuildlineInfo = Boolean
				.valueOf(Configuration.ConfigValues.getProperty("SHOW_ITEM_GUIDELINE_INFO"));
		boolean showCategoryGuildlineInfo = Boolean
				.valueOf(Configuration.ConfigValues.getProperty("SHOW_CATEGORY_GUIDELINE_INFO"));
		boolean packingRequired = Boolean.valueOf(Configuration.ConfigValues.getProperty("PACKING_REQUIRED"));

		if (packingRequired) {
			System.out.println("\nPacking for you.\n--------------------");
			Item item;
			InfoPrinter infoPrinter = new InfoPrinter();

			for (Map.Entry<Item, Integer> itemEntry : CustomersCart.getCart().entrySet()) {
				item = itemEntry.getKey();
				System.out.println("Packing " + item.getItemName() + ". " + item.packing().pack());
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
