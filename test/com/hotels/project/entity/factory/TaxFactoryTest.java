package com.hotels.project.entity.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hotels.project.common.EntityMetadata;
import com.hotels.project.entity.Tax;
import com.hotels.project.exception.InvalidRequestException;

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

	@Test(expected=InvalidRequestException.class)
	public void testUnknown() {
		 taxFactory.getTax(EntityMetadata.UNKNOWN);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetItemGrocerry() {
		 taxFactory.getItem(EntityMetadata.ITEM_GROCERRY);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetItemFragile() {
		 taxFactory.getItem(EntityMetadata.ITEM_FRAGILE);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetItemUnknown() {
		 taxFactory.getItem(EntityMetadata.UNKNOWN);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetCategoryGeneral() {
		 taxFactory.getCategory(EntityMetadata.CATEGORY_GENERAL);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetCategoryHeavyweight() {
		 taxFactory.getCategory(EntityMetadata.CATEGORY_HEAVYWEIGHT);
	}

	@Test(expected=InvalidRequestException.class)
	public void testGetCategoryMedicine() {
		 taxFactory.getCategory(EntityMetadata.CATEGORY_MEDICINE);
	}

}