package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Category;
import com.hotels.project.entity.dto.CategoryDTO;
import com.hotels.project.exception.InvalidRequestException;

public class CategoryNull implements Category {
	CategoryDTO category;

	public CategoryNull()  {
		executeCategorySpecificRule();
	}

	@Override
	public CategoryDTO getCategory()  {
		executeCategorySpecificRule();
		return null;
	}

	public void setCategory(CategoryDTO category)  {
		executeCategorySpecificRule();
		this.category = null;
	}

	@Override
	public void executeCategorySpecificRule() {
		System.out.println("Not an available type of Category.");
		throw new InvalidRequestException();
	}

}
