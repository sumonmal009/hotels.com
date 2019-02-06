package com.hotels.project.entity.factory;

import com.hotels.project.common.EntityMetadata;
import com.hotels.project.entity.Category;
import com.hotels.project.entity.Item;
import com.hotels.project.entity.Tax;

public abstract class AbstractFactory {
	public abstract Item getItem(EntityMetadata itemSalable);

	public abstract Tax getTax(EntityMetadata taxType);

	public abstract Category getCategory(EntityMetadata categoryType);


}
