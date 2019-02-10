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
import com.hotels.project.entity.dto.CategoryDTO;
import com.hotels.project.entity.dto.ItemDTO;
import com.hotels.project.entity.dto.TaxDTO;
import com.hotels.project.entity.factory.AbstractFactory;
import com.hotels.project.entity.factory.FactoryProducer;
import com.hotels.project.entity.implimentation.CategoryGeneral;
import com.hotels.project.entity.implimentation.CategoryGift;
import com.hotels.project.entity.implimentation.CategoryHeavyWeight;
import com.hotels.project.entity.implimentation.CategoryKids;
import com.hotels.project.entity.implimentation.CategoryMedicine;
import com.hotels.project.entity.implimentation.CategoryNewArrival;
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
	CategoryNewArrival categoryNewArrival;

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
		doll.setItem(new ItemDTO());
		doll.getItem().setItemID("item07");
		doll.getItem().setItemName("doll");
		doll.getItem().setItemPrice(80.02f);
		doll.getItem().setDiscount(20);
		doll.getItem().setTaxes(new HashSet<Tax>(Arrays.asList(gstTax, generalSalesTaxKids)));

		flowervas = (ItemFragile) itemFactory.getItem(EntityMetadata.ITEM_FRAGILE);
		flowervas.setItem(new ItemDTO());
		flowervas.getItem().setItemID("item06");
		flowervas.getItem().setItemName("flowervas");
		flowervas.getItem().setItemPrice(200.02f);
		flowervas.getItem().setDiscount(10);
		flowervas.getItem().setTaxes(new HashSet<Tax>(Arrays.asList(gstTax)));

		fridge = (ItemHeavy) itemFactory.getItem(EntityMetadata.ITEM_HEAVY);
		fridge.setItem(new ItemDTO());
		fridge.getItem().setItemID("item05");
		fridge.getItem().setItemName("fridge");
		fridge.getItem().setItemPrice(3000.02f);
		fridge.getItem().setDiscount(10);
		fridge.getItem().setTaxes(new HashSet<Tax>(Arrays.asList(generalSalesTax, gstTax)));

		wine = (ItemGrocerry) itemFactory.getItem(EntityMetadata.ITEM_GROCERRY);
		wine.setItem(new ItemDTO());
		wine.getItem().setItemID("item01");
		wine.getItem().setItemName("wine");
		wine.getItem().setItemPrice(100.02f);
		wine.getItem().setTaxes(new HashSet<Tax>(Arrays.asList(generalSalesTax, alcholeSalesTax)));

		chocolate = (ItemGrocerry) itemFactory.getItem(EntityMetadata.ITEM_GROCERRY);
		chocolate.setItem(new ItemDTO());
		chocolate.getItem().setItemID("item02");
		chocolate.getItem().setItemName("chocolate");
		chocolate.getItem().setItemPrice(80.00f);
		chocolate.getItem().setDiscount(2.0f);
		chocolate.getItem().setTaxes(new HashSet<Tax>(Arrays.asList(generalSalesTax)));

		paracitamol = (ItemMedicine) itemFactory.getItem(EntityMetadata.ITEM_MEDICINE);
		paracitamol.setItem(new ItemDTO());
		paracitamol.getItem().setItemID("item03");
		paracitamol.getItem().setItemName("paracitamol");
		paracitamol.getItem().setItemPrice(10.56f);
		paracitamol.getItem().setDiscount(8);
		paracitamol.getItem().setTaxes(new HashSet<Tax>(Arrays.asList(generalSalesTax)));

		crocine = (ItemMedicine) itemFactory.getItem(EntityMetadata.ITEM_MEDICINE);
		crocine.setItem(new ItemDTO());
		crocine.getItem().setItemID("item04");
		crocine.getItem().setItemName("crocine");
		crocine.getItem().setItemPrice(7.89f);
		crocine.getItem().setDiscount(9);
		crocine.getItem().setTaxes(new HashSet<Tax>(Arrays.asList(medicineSalesTax)));

	}

	private void feedTax() {
		AbstractFactory taxFactory = FactoryProducer.getFactory(EntityMetadata.FACTORY_TAX);
		generalSalesTax = (TaxSales) taxFactory.getTax(EntityMetadata.TAX_SALES);
		generalSalesTax.setTax(new TaxDTO());
		generalSalesTax.getTax().setPercentage(20.00f);
		generalSalesTax.getTax().setTaxID("sale01");
		generalSalesTax.getTax().setTaxName("SalesTax");
		taxTable.put(generalSalesTax.getTax().getTaxName(), generalSalesTax);

		generalSalesTaxKids = (TaxSales) taxFactory.getTax(EntityMetadata.TAX_SALES);
		generalSalesTaxKids.setTax(new TaxDTO());
		generalSalesTaxKids.getTax().setPercentage(-10.02f);
		generalSalesTaxKids.getTax().setTaxID("ksale01");
		generalSalesTaxKids.getTax().setTaxName("SalesTaxKids");
		taxTable.put(generalSalesTaxKids.getTax().getTaxName(), generalSalesTaxKids);

		alcholeSalesTax = (TaxSales) taxFactory.getTax(EntityMetadata.TAX_SALES);
		alcholeSalesTax.setTax(new TaxDTO());
		alcholeSalesTax.getTax().setPercentage(10.00f);
		alcholeSalesTax.getTax().setTaxID("sale02");
		alcholeSalesTax.getTax().setTaxName("Alcholetax");
		taxTable.put(alcholeSalesTax.getTax().getTaxName(), alcholeSalesTax);

		medicineSalesTax = (TaxSales) taxFactory.getTax(EntityMetadata.TAX_SALES);
		medicineSalesTax.setTax(new TaxDTO());
		medicineSalesTax.getTax().setPercentage(0.00f);
		medicineSalesTax.getTax().setTaxID("sale03");
		medicineSalesTax.getTax().setTaxName("freeMedicine");
		taxTable.put(medicineSalesTax.getTax().getTaxName(), medicineSalesTax);

		gstTax = (TaxGST) taxFactory.getTax(EntityMetadata.TAX_GST);
		gstTax.setTax(new TaxDTO());
		gstTax.getTax().setPercentage(0.20f);
		gstTax.getTax().setTaxID("gst1");
		gstTax.getTax().setTaxName("GST");
		taxTable.put(gstTax.getTax().getTaxName(), gstTax);

	}

	private void mappingCategory() { // representing entity relation
		categoryGeneral.getCategory().setItems(new HashSet<Item>(Arrays.asList(wine, chocolate)));
		categoryKids.getCategory().setItems(new HashSet<Item>(Arrays.asList(chocolate)));
		freeMedicine.getCategory().setItems(new HashSet<Item>(Arrays.asList(paracitamol)));

		feedItemCategoryMapping();
	}

	private void feedCategory() {
		AbstractFactory categoryFactory = FactoryProducer.getFactory(EntityMetadata.FACTORY_CATEGORY);

		categoryGeneral = (CategoryGeneral) categoryFactory.getCategory(EntityMetadata.CATEGORY_GENERAL);
		categoryGeneral.setCategory(new CategoryDTO());
		categoryGeneral.getCategory().setCategoryID("cat01");
		categoryGeneral.getCategory().setCategoryName("categoryGeneral");
		categoryGeneral.getCategory().setApplicableTaxs(new HashSet<Tax>(Arrays.asList(generalSalesTax, gstTax)));

		freeMedicine = (CategoryMedicine) categoryFactory.getCategory(EntityMetadata.CATEGORY_MEDICINE);
		freeMedicine.setCategory(new CategoryDTO());
		freeMedicine.getCategory().setCategoryID("cat02");
		freeMedicine.getCategory().setCategoryName("Medicine");
		freeMedicine.getCategory().setDiscount(2.7f);
		freeMedicine.getCategory().setApplicableTaxs(new HashSet<Tax>(Arrays.asList(medicineSalesTax)));

		categoryKids = (CategoryKids) categoryFactory.getCategory(EntityMetadata.CATEGORY_KIDS);
		categoryKids.setCategory(new CategoryDTO());
		categoryKids.getCategory().setCategoryID("cat03");
		categoryKids.getCategory().setCategoryName("GrocerryKids");
		categoryKids.getCategory().setApplicableTaxs(new HashSet<Tax>(Arrays.asList(generalSalesTaxKids)));
		categoryKids.getCategory().setDiscount(3);

		categoryGift = (CategoryGift) categoryFactory.getCategory(EntityMetadata.CATEGORY_GIFT);
		categoryGift.setCategory(new CategoryDTO());
		categoryGift.getCategory().setCategoryID("cat04");
		categoryGift.getCategory().setCategoryName("categoryGift");
		categoryGift.getCategory().setDiscount(5.7f);
		categoryGift.getCategory().setApplicableTaxs(new HashSet<Tax>(Arrays.asList(generalSalesTax)));

		categoryHeavyWeight = (CategoryHeavyWeight) categoryFactory.getCategory(EntityMetadata.CATEGORY_HEAVYWEIGHT);
		categoryHeavyWeight.setCategory(new CategoryDTO());
		categoryHeavyWeight.getCategory().setCategoryID("cat05");
		categoryHeavyWeight.getCategory().setCategoryName("categoryHeavyWeight");
		categoryHeavyWeight.getCategory().setDiscount(15.9f);
		categoryHeavyWeight.getCategory().setApplicableTaxs(new HashSet<Tax>(Arrays.asList(generalSalesTax, gstTax)));

		categoryNewArrival = (CategoryNewArrival) categoryFactory.getCategory(EntityMetadata.CATEGORY_NEW_ARRIAVEL);
		categoryNewArrival.setCategory(new CategoryDTO());
		categoryNewArrival.getCategory().setCategoryID("cat06");
		categoryNewArrival.getCategory().setCategoryName("categoryNewArrival");
		categoryNewArrival.getCategory().setDiscount(30.8f);
		categoryNewArrival.getCategory().setApplicableTaxs(new HashSet<Tax>(Arrays.asList(generalSalesTax, gstTax)));

	}

	private void feedItemCategoryMapping() { // representing Table
		itemCategoryMapping.put(wine, new HashSet<Category>(Arrays.asList(categoryGeneral)));
		itemCategoryMapping.put(chocolate, new HashSet<Category>(Arrays.asList(categoryGeneral, categoryKids)));
		itemCategoryMapping.put(paracitamol, new HashSet<Category>(Arrays.asList(freeMedicine)));
		itemCategoryMapping.put(crocine, new HashSet<Category>(Arrays.asList(freeMedicine)));
		itemCategoryMapping.put(doll, new HashSet<Category>(Arrays.asList(categoryKids, categoryGift)));
		itemCategoryMapping.put(fridge, new HashSet<Category>(Arrays.asList(categoryHeavyWeight,categoryNewArrival)));
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
