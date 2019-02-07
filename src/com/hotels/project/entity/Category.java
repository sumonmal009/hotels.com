package com.hotels.project.entity;

import com.hotels.project.entity.dto.CategoryDTO;

public interface Category {

	public CategoryDTO getCategory();

	void executeCategorySpecificRule();
}
