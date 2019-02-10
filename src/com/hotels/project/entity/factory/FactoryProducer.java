package com.hotels.project.entity.factory;

import com.hotels.project.common.EntityMetadata;
import com.hotels.project.exception.InvalidRequestException;

public class FactoryProducer {

	public static AbstractFactory getFactory(EntityMetadata factoryItem)  {
		switch (factoryItem) {
		case FACTORY_ITEM:
			return new ItemFactory();

		case FACTORY_CATEGORY:
			return new CategoryFactory();

		case FACTORY_TAX:
			return new TaxFactory();

		default:
			return new NullFactory();
		}
	}

}
