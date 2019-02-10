package com.hotels.project.entity.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hotels.project.common.EntityMetadata;
import com.hotels.project.entity.Item;
import com.hotels.project.exception.InvalidRequestException;

public class ItemFactoryTest {

	private ItemFactory itemFactory;

	@Before
	public void executeBefore() {
		itemFactory = new ItemFactory();
	}

	@Test(expected=InvalidRequestException.class)
	public void testSalesTax() {
		itemFactory.getTax(EntityMetadata.TAX_SALES);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGST() {
		itemFactory.getTax(EntityMetadata.TAX_GST);
	}

	@Test(expected=InvalidRequestException.class)
	public void testUnknown() {
		itemFactory.getTax(EntityMetadata.UNKNOWN);
	}

	@Test
	public void testGetItemGrocerry() {
		Assert.assertTrue(itemFactory.getItem(EntityMetadata.ITEM_GROCERRY) instanceof Item);
	}

	@Test
	public void testGetItemFragile() {
		Assert.assertTrue(itemFactory.getItem(EntityMetadata.ITEM_FRAGILE) instanceof Item);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetItemUnknown() {
		itemFactory.getItem(EntityMetadata.UNKNOWN);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetCategoryGeneral() {
		itemFactory.getCategory(EntityMetadata.CATEGORY_GENERAL);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetCategoryHeavyweight() {
		itemFactory.getCategory(EntityMetadata.CATEGORY_HEAVYWEIGHT);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetCategoryMedicine() {
		itemFactory.getCategory(EntityMetadata.CATEGORY_MEDICINE);
	}

}
