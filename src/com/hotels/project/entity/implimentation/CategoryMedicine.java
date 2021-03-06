package com.hotels.project.entity.implimentation;

import com.hotels.project.entity.Category;
import com.hotels.project.entity.dto.CategoryDTO;

public class CategoryMedicine implements Category {
	CategoryDTO category;

	@Override
	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	@Override
	public void executeCategorySpecificRule() {
		System.out.println("\tINFO: Ask for prescption.");
	}

	@Override
	public int hashCode() {
		return category.getCategoryName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Category))
			return false;
		if (obj == this)
			return true;
		return this.category.getCategoryName().equals(((Category) obj).getCategory().getCategoryName());
	}

}
