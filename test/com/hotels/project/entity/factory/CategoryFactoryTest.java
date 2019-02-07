package com.hotels.project.entity.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hotels.project.common.EntityMetadata;
import com.hotels.project.entity.Category;

public class CategoryFactoryTest {

	private CategoryFactory categoryFactory;

	@Before
	public void executeBefore() {
		categoryFactory = new CategoryFactory();
	}

	@Test
	public void testSalesTax() {
		Assert.assertNull(categoryFactory.getTax(EntityMetadata.TAX_SALES));
	}

	@Test
	public void testGST() {
		Assert.assertNull(categoryFactory.getTax(EntityMetadata.TAX_GST));
	}

	@Test
	public void testUnknown() {
		Assert.assertNull(categoryFactory.getTax(EntityMetadata.UNKNOWN));
	}

	@Test
	public void testGetItemGrocerry() {
		Assert.assertNull(categoryFactory.getTax(EntityMetadata.ITEM_GROCERRY));
	}

	@Test
	public void testGetItemFragile() {
		Assert.assertNull(categoryFactory.getTax(EntityMetadata.ITEM_FRAGILE));
	}

	@Test
	public void testGetItemUnknown() {
		Assert.assertNull(categoryFactory.getTax(EntityMetadata.UNKNOWN));
	}

	@Test
	public void testGetCategoryGeneral() {
		Assert.assertTrue(categoryFactory.getCategory(EntityMetadata.CATEGORY_GENERAL) instanceof Category);
	}

	@Test
	public void testGetCategoryHeavyweight() {
		Assert.assertTrue(categoryFactory.getCategory(EntityMetadata.CATEGORY_HEAVYWEIGHT) instanceof Category);
	}

	@Test
	public void testGetCategoryMedicine() {
		Assert.assertTrue(categoryFactory.getCategory(EntityMetadata.CATEGORY_MEDICINE) instanceof Category);
	}

}
