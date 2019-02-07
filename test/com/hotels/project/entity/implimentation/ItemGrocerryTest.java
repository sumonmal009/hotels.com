package com.hotels.project.entity.implimentation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hotels.project.entity.dto.ItemDTO;

public class ItemGrocerryTest {

	ItemGrocerry item;
	ItemDTO dto;

	@Before
	public void executeBefore() {
		item = new ItemGrocerry();
		dto = new ItemDTO();
	}

	@Test
	public void testGetCategory() {
		item.setItem(dto);
		Assert.assertTrue(item.getItem() instanceof ItemDTO);
	}

	@Test
	public void testNull() {
		item.setItem(null);
		Assert.assertNull(item.getItem());
	}

}
