package com.hotels.project.cart;

import java.util.HashMap;
import java.util.Map;

import com.hotels.project.entity.Item;

public class CustomersCart {

	public static Map<Item, Integer> cart = new HashMap<>();

	public void addToCart(Item item) {
		if (cart.containsKey(item)) {
			cart.put(item, cart.get(item) + 1);
		} else {
			cart.put(item, 1);
		}
	}

	public void removeFromCart(Item item) {
		if (cart.containsKey(item)) {
			if (cart.get(item) > 1)
				cart.put(item, cart.get(item) - 1);
		} else {
			cart.remove(item);
		}
	}

	public static Map<Item, Integer> getCart() {
		return cart;
	}

}
