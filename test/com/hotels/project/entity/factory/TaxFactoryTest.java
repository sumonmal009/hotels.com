package com.hotels.project.entity.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hotels.project.common.EntityMetadata;
import com.hotels.project.entity.Tax;
import com.hotels.project.entity.factory.TaxFactory;

public class TaxFactoryTest {

	private TaxFactory taxFactory;

	@Before
	public void executeBefore() {
		taxFactory = new TaxFactory();
	}

	@Test
	public void testSalesTax() {
		Assert.assertTrue(taxFactory.getTax(EntityMetadata.TAX_SALES) instanceof Tax);
	}

	@Test
	public void testGST() {
		Assert.assertTrue(taxFactory.getTax(EntityMetadata.TAX_GST) instanceof Tax);
	}

	@Test
	public void testUnknown() {
		Assert.assertEquals(null, taxFactory.getTax(EntityMetadata.UNKNOWN));
	}

	@Test
	public void testGetItemGrocerry() {
		Assert.assertEquals(null, taxFactory.getItem(EntityMetadata.ITEM_GROCERRY));
	}

	@Test
	public void testGetItemFragile() {
		Assert.assertEquals(null, taxFactory.getItem(EntityMetadata.ITEM_FRAGILE));
	}

	@Test
	public void testGetItemUnknown() {
		Assert.assertEquals(null, taxFactory.getItem(EntityMetadata.UNKNOWN));
	}

	@Test
	public void testGetCategoryGeneral() {
		Assert.assertEquals(null, taxFactory.getCategory(EntityMetadata.CATEGORY_GENERAL));
	}

	@Test
	public void testGetCategoryHeavyweight() {
		Assert.assertEquals(null, taxFactory.getCategory(EntityMetadata.CATEGORY_HEAVYWEIGHT));
	}

	@Test
	public void testGetCategoryMedicine() {
		Assert.assertEquals(null, taxFactory.getCategory(EntityMetadata.CATEGORY_MEDICINE));
	}

}