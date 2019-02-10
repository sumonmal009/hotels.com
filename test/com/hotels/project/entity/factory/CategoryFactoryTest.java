package com.hotels.project.entity.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hotels.project.common.EntityMetadata;
import com.hotels.project.entity.Category;
import com.hotels.project.exception.InvalidRequestException;

public class CategoryFactoryTest {

	private CategoryFactory categoryFactory;

	@Before
	public void executeBefore() {
		categoryFactory = new CategoryFactory();
	}

	@Test(expected=InvalidRequestException.class)
	public void testSalesTax() {
		categoryFactory.getTax(EntityMetadata.TAX_SALES);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGST() {
		categoryFactory.getTax(EntityMetadata.TAX_GST);
	}

	@Test(expected = InvalidRequestException.class)
	public void testUnknown() {
		categoryFactory.getTax(EntityMetadata.UNKNOWN);
	}

	@Test(expected = InvalidRequestException.class)
	public void testGetItemGrocerry() {
		categoryFactory.getTax(EntityMetadata.ITEM_GROCERRY);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetItemFragile() {
		categoryFactory.getTax(EntityMetadata.ITEM_FRAGILE);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetItemUnknown() {
		categoryFactory.getTax(EntityMetadata.UNKNOWN);
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
