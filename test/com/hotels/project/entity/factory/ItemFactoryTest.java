package com.hotels.project.entity.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hotels.project.common.EntityMetadata;
import com.hotels.project.entity.Item;

public class ItemFactoryTest {

	private ItemFactory itemFactory;

	@Before
	public void executeBefore() {
		itemFactory = new ItemFactory();
	}

	@Test
	public void testSalesTax() {
		Assert.assertNull(itemFactory.getTax(EntityMetadata.TAX_SALES));
	}

	@Test
	public void testGST() {
		Assert.assertNull(itemFactory.getTax(EntityMetadata.TAX_GST));
	}

	@Test
	public void testUnknown() {
		Assert.assertNull(itemFactory.getTax(EntityMetadata.UNKNOWN));
	}

	@Test
	public void testGetItemGrocerry() {
		Assert.assertTrue(itemFactory.getItem(EntityMetadata.ITEM_GROCERRY) instanceof Item);
	}

	@Test
	public void testGetItemFragile() {
		Assert.assertTrue(itemFactory.getItem(EntityMetadata.ITEM_FRAGILE) instanceof Item);
	}

	@Test
	public void testGetItemUnknown() {
		Assert.assertNull(itemFactory.getItem(EntityMetadata.UNKNOWN));
	}

	@Test
	public void testGetCategoryGeneral() {
		Assert.assertNull(itemFactory.getCategory(EntityMetadata.CATEGORY_GENERAL));
	}

	@Test
	public void testGetCategoryHeavyweight() {
		Assert.assertNull(itemFactory.getCategory(EntityMetadata.CATEGORY_HEAVYWEIGHT));
	}

	@Test
	public void testGetCategoryMedicine() {
		Assert.assertNull(itemFactory.getCategory(EntityMetadata.CATEGORY_MEDICINE));
	}

}
