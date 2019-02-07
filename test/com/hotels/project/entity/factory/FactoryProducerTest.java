package com.hotels.project.entity.factory;

import org.junit.Assert;
import org.junit.Test;

import com.hotels.project.common.EntityMetadata;

public class FactoryProducerTest {

	@Test
	public void testUnknown() {
		Assert.assertNull(FactoryProducer.getFactory(EntityMetadata.UNKNOWN));
	}

	@Test
	public void testFactoryGeneral() {
		Assert.assertTrue(FactoryProducer.getFactory(EntityMetadata.FACTORY_CATEGORY) instanceof AbstractFactory);
	}

	@Test
	public void testFactoryTaxl() {
		Assert.assertTrue(FactoryProducer.getFactory(EntityMetadata.FACTORY_TAX) instanceof AbstractFactory);
	}

	@Test
	public void testFactoryItem() {
		Assert.assertTrue(FactoryProducer.getFactory(EntityMetadata.FACTORY_ITEM) instanceof AbstractFactory);
	}

}
