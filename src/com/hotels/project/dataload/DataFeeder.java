package com.hotels.project.dataload;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.hotels.project.cart.CustomersCart;
import com.hotels.project.common.EntityMetadata;
import com.hotels.project.entity.Category;
import com.hotels.project.entity.Item;
import com.hotels.project.entity.Tax;
import com.hotels.project.entity.factory.AbstractFactory;
import com.hotels.project.entity.factory.FactoryProducer;
import com.hotels.project.entity.implimentation.CategoryGeneral;
import com.hotels.project.entity.implimentation.CategoryGift;
import com.hotels.project.entity.implimentation.CategoryHeavyWeight;
import com.hotels.project.entity.implimentation.CategoryKids;
import com.hotels.project.entity.implimentation.CategoryMedicine;
import com.hotels.project.entity.implimentation.ItemFragile;
import com.hotels.project.entity.implimentation.ItemGift;
import com.hotels.project.entity.implimentation.ItemGrocerry;
import com.hotels.project.entity.implimentation.ItemHeavy;
import com.hotels.project.entity.implimentation.ItemMedicine;
import com.hotels.project.entity.implimentation.TaxGST;
import com.hotels.project.entity.implimentation.TaxSales;

public class DataFeeder {
	public static HashMap<Item, Set<Category>> itemCategoryMapping = new HashMap<>();
	public static HashMap<String, Tax> taxTable = new HashMap<>();
	public CustomersCart cart;

	TaxSales generalSalesTax, generalSalesTaxKids, alcholeSalesTax, medicineSalesTax;
	TaxGST gstTax;
	ItemGrocerry wine, chocolate;
	ItemHeavy fridge;
	ItemMedicine paracitamol, crocine;
	ItemFragile flowervas;
	ItemGift doll;

	CategoryGeneral categoryGeneral;
	CategoryKids categoryKids;
	CategoryMedicine freeMedicine;
	CategoryGift categoryGift;
	CategoryHeavyWeight categoryHeavyWeight;
	CategoryMedicine categoryMedicine;

	public DataFeeder() {
		feedTax();
		feedItem();
		feedCategory();
		mappingCategory();
		System.out.println("Data Feed completed.");
		addItemstoCart();
		System.out.println("\n\nItem Added to Cart: " + CustomersCart.getCart().size());
	}

	private void feedItem() {
		AbstractFactory itemFactory = FactoryProducer.getFactory(EntityMetadata.FACTORY_ITEM);

		doll = (ItemGift) itemFactory.getItem(EntityMetadata.ITEM_GIFT);
		doll.setItemID("item07");
		doll.setItemName("doll");
		doll.setItemPrice(80.02f);
		doll.setDiscount(20);
		doll.setTaxes(new HashSet<Tax>(Arrays.asList(gstTax, generalSalesTaxKids)));

		flowervas = (ItemFragile) itemFactory.getItem(EntityMetadata.ITEM_FRAGILE);
		flowervas.setItemID("item06");
		flowervas.setItemName("flowervas");
		flowervas.setItemPrice(200.02f);
		flowervas.setDiscount(10);
		flowervas.setTaxes(new HashSet<Tax>(Arrays.asList(gstTax)));

		fridge = (ItemHeavy) itemFactory.getItem(EntityMetadata.ITEM_HEAVY);
		fridge.setItemID("item05");
		fridge.setItemName("fridge");
		fridge.setItemPrice(1000.02f);
		fridge.setDiscount(10);
		fridge.setTaxes(new HashSet<Tax>(Arrays.asList(generalSalesTax, gstTax)));

		wine = (ItemGrocerry) itemFactory.getItem(EntityMetadata.ITEM_GROCERRY);
		wine.setItemID("item01");
		wine.setItemName("wine");
		wine.setItemPrice(100.02f);
		wine.setTaxes(new HashSet<Tax>(Arrays.asList(generalSalesTax, alcholeSalesTax)));

		chocolate = (ItemGrocerry) itemFactory.getItem(EntityMetadata.ITEM_GROCERRY);
		chocolate.setItemID("item02");
		chocolate.setItemName("chocolate");
		chocolate.setItemPrice(80.00f);
		chocolate.setDiscount(2.0f);
		chocolate.setTaxes(new HashSet<Tax>(Arrays.asList(generalSalesTax)));

		paracitamol = (ItemMedicine) itemFactory.getItem(EntityMetadata.ITEM_MEDICINE);
		paracitamol.setItemID("item03");
		paracitamol.setItemName("paracitamol");
		paracitamol.setItemPrice(10.56f);
		paracitamol.setDiscount(8);
		paracitamol.setTaxes(new HashSet<Tax>(Arrays.asList(generalSalesTax)));

		crocine = (ItemMedicine) itemFactory.getItem(EntityMetadata.ITEM_MEDICINE);
		crocine.setItemID("item04");
		crocine.setItemName("crocine");
		crocine.setItemPrice(7.89f);
		crocine.setDiscount(9);
		crocine.setTaxes(new HashSet<Tax>(Arrays.asList(medicineSalesTax)));

	}

	private void feedTax() {
		AbstractFactory taxFactory = FactoryProducer.getFactory(EntityMetadata.FACTORY_TAX);
		generalSalesTax = (TaxSales) taxFactory.getTax(EntityMetadata.TAX_SALES);
		generalSalesTax.setPercentage(20.00f);
		generalSalesTax.setTaxID("sale01");
		generalSalesTax.setTaxName("SalesTax");
		taxTable.put(generalSalesTax.getTaxName(), generalSalesTax);

		generalSalesTaxKids = (TaxSales) taxFactory.getTax(EntityMetadata.TAX_SALES);
		generalSalesTaxKids.setPercentage(-10.02f);
		generalSalesTaxKids.setTaxID("ksale01");
		generalSalesTaxKids.setTaxName("SalesTaxKids");
		taxTable.put(generalSalesTaxKids.getTaxName(), generalSalesTaxKids);

		alcholeSalesTax = (TaxSales) taxFactory.getTax(EntityMetadata.TAX_SALES);
		alcholeSalesTax.setPercentage(10.00f);
		alcholeSalesTax.setTaxID("sale02");
		alcholeSalesTax.setTaxName("Alcholetax");
		taxTable.put(alcholeSalesTax.getTaxName(), alcholeSalesTax);

		medicineSalesTax = (TaxSales) taxFactory.getTax(EntityMetadata.TAX_SALES);
		medicineSalesTax.setPercentage(0.00f);
		medicineSalesTax.setTaxID("sale03");
		medicineSalesTax.setTaxName("freeMedicine");
		taxTable.put(medicineSalesTax.getTaxName(), medicineSalesTax);

		gstTax = (TaxGST) taxFactory.getTax(EntityMetadata.TAX_GST);
		gstTax.setPercentage(0.20f);
		gstTax.setTaxID("gst1");
		gstTax.setTaxName("GST");
		taxTable.put(gstTax.getTaxName(), gstTax);

	}

	private void feedCategory() {
		AbstractFactory categoryFactory = FactoryProducer.getFactory(EntityMetadata.FACTORY_CATEGORY);

		categoryGeneral = (CategoryGeneral) categoryFactory.getCategory(EntityMetadata.CATEGORY_GENERAL);
		categoryGeneral.setCategoryID("cat01");
		categoryGeneral.setCategoryName("categoryGeneral");
		categoryGeneral.setApplicableTaxs(new HashSet<Tax>(Arrays.asList(generalSalesTax, gstTax)));

		freeMedicine = (CategoryMedicine) categoryFactory.getCategory(EntityMetadata.CATEGORY_MEDICINE);
		freeMedicine.setCategoryID("cat02");
		freeMedicine.setCategoryName("Medicine");
		freeMedicine.setDiscount(2.7f);
		freeMedicine.setApplicableTaxs(new HashSet<Tax>(Arrays.asList(medicineSalesTax)));

		categoryKids = (CategoryKids) categoryFactory.getCategory(EntityMetadata.CATEGORY_KIDS);
		categoryKids.setCategoryID("cat03");
		categoryKids.setCategoryName("GrocerryKids");
		categoryKids.setApplicableTaxs(new HashSet<Tax>(Arrays.asList(generalSalesTaxKids)));
		categoryKids.setDiscount(3);

		categoryGift = (CategoryGift) categoryFactory.getCategory(EntityMetadata.CATEGORY_GIFT);
		categoryGift.setCategoryID("cat04");
		categoryGift.setCategoryName("categoryGift");
		categoryGift.setDiscount(5.7f);
		categoryGift.setApplicableTaxs(new HashSet<Tax>(Arrays.asList(generalSalesTax)));

		categoryHeavyWeight = (CategoryHeavyWeight) categoryFactory.getCategory(EntityMetadata.CATEGORY_HEAVYWEIGHT);
		categoryHeavyWeight.setCategoryID("cat05");
		categoryHeavyWeight.setCategoryName("categoryHeavyWeight");
		categoryHeavyWeight.setDiscount(15.8f);
		categoryHeavyWeight.setApplicableTaxs(new HashSet<Tax>(Arrays.asList(generalSalesTax, gstTax)));

	}

	private void mappingCategory() { // representing entity relation
		categoryGeneral.setItems(new HashSet<Item>(Arrays.asList(wine, chocolate)));
		categoryKids.setItems(new HashSet<Item>(Arrays.asList(chocolate)));
		freeMedicine.setItems(new HashSet<Item>(Arrays.asList(paracitamol)));

		feedItemCategoryMapping();
	}

	private void feedItemCategoryMapping() { // representing Table
		itemCategoryMapping.put(wine, new HashSet<Category>(Arrays.asList(categoryGeneral)));
		itemCategoryMapping.put(chocolate, new HashSet<Category>(Arrays.asList(categoryGeneral, categoryKids)));
		itemCategoryMapping.put(paracitamol, new HashSet<Category>(Arrays.asList(freeMedicine)));
		itemCategoryMapping.put(crocine, new HashSet<Category>(Arrays.asList(freeMedicine)));
		itemCategoryMapping.put(doll, new HashSet<Category>(Arrays.asList(categoryKids, categoryGift)));
		itemCategoryMapping.put(fridge, new HashSet<Category>(Arrays.asList(categoryHeavyWeight, categoryGeneral)));
		itemCategoryMapping.put(flowervas, new HashSet<Category>(Arrays.asList(categoryGift)));
	}

	private void addItemstoCart() {
		cart = new CustomersCart();
		cart.addToCart(wine);
		cart.addToCart(wine);
		cart.addToCart(chocolate);
		cart.addToCart(paracitamol);
		cart.addToCart(crocine);
		cart.addToCart(crocine);
		cart.addToCart(fridge);
		cart.addToCart(flowervas);
		cart.addToCart(doll);
		
		
		

	}

}
