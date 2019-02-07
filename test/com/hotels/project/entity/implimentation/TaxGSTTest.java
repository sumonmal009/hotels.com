package com.hotels.project.entity.implimentation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hotels.project.entity.dto.TaxDTO;

public class TaxGSTTest {

	TaxGST tax;
	TaxDTO dto;

	@Before
	public void executeBefore() {
		tax = new TaxGST();
		dto = new TaxDTO();
	}

	@Test
	public void testGetCategory() {
		tax.setTax(dto);
		Assert.assertTrue(tax.getTax() instanceof TaxDTO);
	}

	@Test
	public void testNull() {
		tax.setTax(null);
		Assert.assertNull(tax.getTax());
	}

}
