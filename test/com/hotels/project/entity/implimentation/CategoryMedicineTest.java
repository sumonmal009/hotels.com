package com.hotels.project.entity.implimentation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hotels.project.entity.dto.CategoryDTO;

public class CategoryMedicineTest {

	CategoryMedicine category;
	CategoryDTO dto;

	@Before
	public void executeBefore() {
		category = new CategoryMedicine();
		dto = new CategoryDTO();
	}

	@Test
	public void testGetCategory() {
		category.setCategory(dto);
		Assert.assertTrue(category.getCategory() instanceof CategoryDTO);
	}

	@Test
	public void testNull() {
		category.setCategory(null);
		Assert.assertNull(category.getCategory());
	}

}
