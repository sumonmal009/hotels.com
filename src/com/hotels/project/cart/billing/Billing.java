package com.hotels.project.cart.billing;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hotels.project.cart.CustomersCart;
import com.hotels.project.common.Configuration;
import com.hotels.project.dataload.DataFeeder;
import com.hotels.project.entity.Category;
import com.hotels.project.entity.Item;
import com.hotels.project.entity.Tax;
import com.hotels.project.util.DateTime;

public class Billing {

	boolean categoryOverride = Boolean.valueOf(Configuration.ConfigValues.getProperty("CATEGORY_OVERRIDE"));
	boolean considerHigherTaxOverride = Boolean
			.valueOf(Configuration.ConfigValues.getProperty("CONSIDER_HIGHER_TAX_OVERRIDE"));
	boolean considerLowerTaxOverride = Boolean
			.valueOf(Configuration.ConfigValues.getProperty("CONSIDER_LOWER_TAX_OVERRIDE"));
	DecimalFormat decimalFormat = new DecimalFormat("#.00");
	boolean discountOnCategory = Boolean.valueOf(Configuration.ConfigValues.getProperty("CATEGORY_DISCOUNT"));
	boolean discountOnProduct = Boolean.valueOf(Configuration.ConfigValues.getProperty("PRODUCT_DISCOUNT"));
	boolean enforceMandatoryTaxes = Boolean.valueOf(Configuration.ConfigValues.getProperty("ENFORCE_MANDATORY_TAXES"));
	float faltOffAll = Float.valueOf(Configuration.ConfigValues.getProperty("FLAT_OFF_ALL", "0"));
	float itemTaxableamount = 0;
	boolean revokeTaxesFromAll = Boolean.valueOf(Configuration.ConfigValues.getProperty("REVOKE_TAXES_FROM_ALL"));
	boolean showTaxDetailsOnBill = Boolean.valueOf(Configuration.ConfigValues.getProperty("SHOW_TAX_DETAILS_ON_BILL"));
	float total = 0;
	float totaltaxes = 0;

	public void calculateBill() {
		System.out.println("-------------------Bill-------------------" + "\n\t" + DateTime.getCurrentDateTime());
		Map<Item, Integer> cart = getCart();
		List<Tax> taxlist = null, itemTaxes = null, categoryTaxes = null;
		float itemDiscount = 0.0f;
		float categoryDiscountpercent = 0.0f;
		float categoryDiscount = 0.0f;
		for (Map.Entry<Item, Integer> itemEntry : cart.entrySet()) {
			Item item = itemEntry.getKey();
			int itemQuantity = itemEntry.getValue();
			float itemPriceWithQuantity = item.getItem().getItemPrice()* itemQuantity;
			System.out.println("Item: " + item.getItem().getItemName() + " Qty1 Price: " + decimalFormat.format(item.getItem().getItemPrice()) +" Quantity:"+itemQuantity+" Price:"+decimalFormat.format(itemPriceWithQuantity));
			if (discountOnProduct && faltOffAll == 0) {
				itemDiscount = (itemPriceWithQuantity * (item.getItem().getDiscount() / 100));
				System.out.println("Discount on Item:" + decimalFormat.format(item.getItem().getDiscount()) + " is: "
						+ decimalFormat.format(itemDiscount));
			}
			if (discountOnCategory && faltOffAll == 0) {

				for (Category category : DataFeeder.itemCategoryMapping.get(item)) {
					categoryDiscountpercent = categoryDiscountpercent + category.getCategory().getDiscount();

				}
				categoryDiscount = ((itemPriceWithQuantity - itemDiscount) * (categoryDiscountpercent / 100));
				System.out.println("Discount on Category: [" + DataFeeder.itemCategoryMapping.get(item).size()
						+ " category]" + decimalFormat.format(categoryDiscountpercent) + "% is: " + decimalFormat.format(categoryDiscount));
			}
			total = total + itemPriceWithQuantity - itemDiscount - categoryDiscount;

			float categoryTaxpercent = 0.0f;
			float itemTaxpercent = 0.0f;

			if (categoryOverride == false || considerHigherTaxOverride == true || considerLowerTaxOverride == true) {
				itemTaxes = new LinkedList<>();
				Iterator<Tax> taxes = getTaxes(item).iterator();
				while (taxes.hasNext()) {
					Tax tax = taxes.next();
					itemTaxes.add(tax);
					itemTaxpercent = itemTaxpercent + tax.getTax().getPercentage();
				}

			}
			if (categoryOverride == true || considerHigherTaxOverride == true || considerLowerTaxOverride == true) {
				categoryTaxes = new LinkedList<>();
				for (Category category : DataFeeder.itemCategoryMapping.get(item)) {
					Iterator<Tax> taxes = getTaxes(category).iterator();
					while (taxes.hasNext()) {
						Tax tax = taxes.next();
						categoryTaxes.add(tax);
						categoryTaxpercent = categoryTaxpercent + tax.getTax().getPercentage();
					}
				}

			}

			float taxpercent = 0.00f;
			taxlist = null;
			if (considerHigherTaxOverride == true) {
				taxpercent = Math.max(categoryTaxpercent, itemTaxpercent);
				taxlist = (categoryTaxpercent > itemTaxpercent) ? categoryTaxes : itemTaxes;
			} else if (considerLowerTaxOverride == true) {
				taxpercent = Math.min(categoryTaxpercent, itemTaxpercent);
				taxlist = (categoryTaxpercent < itemTaxpercent) ? categoryTaxes : itemTaxes;
			} else if (categoryOverride == true) {
				taxpercent = categoryTaxpercent;
				taxlist = categoryTaxes;
			} else {
				taxpercent = itemTaxpercent;
				taxlist = itemTaxes;
			}
			float itemPrice = 0.0f;
			if (faltOffAll > 0) {
				itemPrice = itemPriceWithQuantity - (itemPriceWithQuantity * (faltOffAll / 100));
				System.out.println("Applied Flat off Discount of " + decimalFormat.format(faltOffAll)
						+ "% Item price after discount: " + decimalFormat.format(itemPrice));
			} else {
				itemPrice = itemPriceWithQuantity;
			}
			itemTaxableamount = (itemPrice * (taxpercent / 100));
			totaltaxes += itemTaxableamount;
			total += itemTaxableamount;
			if (showTaxDetailsOnBill) {
				System.out.println("\tApplicable tax:" + taxlist);
			}
			System.out.println("\t\t with Tax & Discount:"
					+ decimalFormat.format((itemPrice + (itemTaxableamount - itemDiscount - categoryDiscount))) + "\n");

			itemDiscount = 0.0f;
			categoryDiscount = 0.0f;

		}

		System.out.println("Total tax: " + decimalFormat.format(totaltaxes));
		System.out.println("Total Amount:" + decimalFormat.format(total));
		System.out.println("--------------------------------------------");

	}

	private Map<Item, Integer> getCart() {
		return CustomersCart.getCart();
	}

	private Set<Tax> getTaxes(Object obj) {
		Set<Tax> taxes = new HashSet<>();
		if (obj instanceof Category) {
			taxes = ((Category) obj).getCategory().getApplicableTaxs();
		} else if (obj instanceof Item) {
			taxes = ((Item) obj).getItem().getApplicableTaxs();
		}

		// Filter Patern
		if (enforceMandatoryTaxes) {

			List<String> enforceTax = Arrays
					.asList(Configuration.ConfigValues.getProperty("MANDATORY_TAXES").split(":"));
			for (String tax : enforceTax) {
				taxes.add(DataFeeder.taxTable.get(tax));
			}

		}
		if (revokeTaxesFromAll) {
			List<String> revokeTax = Arrays
					.asList(Configuration.ConfigValues.getProperty("NOT_APPLICABLE_TAXES").split(":"));
			for (String tax : revokeTax) {
				taxes.remove(DataFeeder.taxTable.get(tax));
			}
		}

		return taxes;

	}

}
