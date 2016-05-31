package com.fruitbasket.cart;

import com.fruitbasket.item.ItemElement;
import com.fruitbasket.visitor.ShoppingCartVisitor;
import com.fruitbasket.visitor.ShoppingCartVisitorImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is not thread safe
 * To keep it simple remove from basket is not implemented
 */
public class ShoppingCart {

	List<ItemElement> itemElements = new ArrayList();

	public void addToBasket(ItemElement itemElement) {
		itemElements.add(itemElement);
	}

	public double getTotalPrice() {
		double totalPrice = 0.0;
		ShoppingCartVisitor shoppingCartVisitor = new ShoppingCartVisitorImpl();
		for (ItemElement itemElement : itemElements) {
			totalPrice = totalPrice + itemElement.accept(shoppingCartVisitor);
		}

		return totalPrice;

	}

}
